package com.vickikbt.devtyme.ui.fragment.home

import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.vickikbt.devtyme.R
import com.vickikbt.devtyme.databinding.FragmentHomeBinding
import com.vickikbt.devtyme.models.Summary
import com.vickikbt.devtyme.ui.adapters.LanguagesAdapter
import com.vickikbt.devtyme.ui.adapters.ProjectsAdapter
import com.vickikbt.devtyme.ui.adapters.WorkOverviewAdapter
import com.vickikbt.devtyme.utils.Constants.RANGE_TODAY
import com.vickikbt.devtyme.utils.Helpers.getDaysOfWeek
import com.vickikbt.devtyme.utils.Helpers.getDaysOfWeekRange
import com.vickikbt.devtyme.utils.Helpers.getTimeOfDay
import com.vickikbt.devtyme.utils.LineChartValueFormatter
import com.vickikbt.devtyme.utils.StateListener
import com.vickikbt.devtyme.utils.getDisplayName
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class HomeFragment : Fragment(), StateListener {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()

    private val animationDuration = 1400

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel.stateListener = this

        //setFullScreen(false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        binding.imageViewProfilePic.setOnClickListener { viewModel.revokeToken() }

        initGreeting()
        initDayPicker()

        viewModel.getSummary(range = RANGE_TODAY).observe(viewLifecycleOwner) { summaries ->
            summaries.forEach { summary ->
                initDailyGoal(summary)
                initWorkOverview(summary)
                initProjects(summary)
                initLanguages(summary)
            }
        }

        initWeeklyProgress()

    }

    private fun initGreeting() {
        val greetingMessage = getTimeOfDay()
        viewModel.currentUser.observe(viewLifecycleOwner) { user ->
            binding.textViewGreeting.text =
                "$greetingMessage ${user.displayName?.getDisplayName()}."
            Glide.with(this).load(user.photo).circleCrop().into(binding.imageViewProfilePic)
        }
    }

    private fun initDayPicker() {
        val days = getDaysOfWeek()

        days.forEach {
            binding.tabLayoutHome.addTab(binding.tabLayoutHome.newTab().setText(it))
        }
    }


    private fun initDailyGoal(summary: Summary) {
        val userDailyGoal = 10

        binding.progressBarDailyWorkProgress.max = userDailyGoal * 60 * 60

        val grandTotal = summary.grandTotal!!

        val userDailyProgress = grandTotal.totalSeconds!!.toInt()
        ObjectAnimator.ofInt(
            binding.progressBarDailyWorkProgress,
            "progress",
            userDailyProgress
        ).setDuration(animationDuration.toLong()).start()

        val hours = grandTotal.hours!!
        val minutes = grandTotal.minutes!!
        val dailyWorkProgress = "Worked ${hours}hrs ${minutes}mins of ${userDailyGoal}hrs"

        binding.textViewDailyWorkProgress.text = dailyWorkProgress

    }

    private fun initWeeklyProgress() {
        val daysRange = getDaysOfWeekRange()
        val startDate = daysRange[0]!!
        val endDate = daysRange[6]!!

        viewModel.getWeekSummary(startDate, endDate).observe(viewLifecycleOwner) { summaries ->
            val grandTotalHours = arrayListOf<Float>()
            summaries.forEach { summary ->
                val timeInFloat = (summary.grandTotal?.hours)!!.toFloat()
                grandTotalHours.add(timeInFloat)
            }
            initGraphUI(grandTotalHours)
        }

    }

    private fun initGraphUI(hoursWorked: List<Float>) {
        val poppinsBold = ResourcesCompat.getFont(requireActivity(), R.font.poppins_bold)
        val poppinsMedium = ResourcesCompat.getFont(requireActivity(), R.font.poppins_medium)

        binding.lineChartWeeklyProgress.apply {
            setDrawBorders(false)
            legend.isEnabled = false
            description.isEnabled = false
            setBackgroundColor(Color.TRANSPARENT)
            setGridBackgroundColor(Color.TRANSPARENT)
            setDrawGridBackground(true)
            setPinchZoom(false)
            setTouchEnabled(false)
            isDragEnabled = false
            isScaleXEnabled = false
            axisRight.isEnabled = false
        }

        val leftAxis = binding.lineChartWeeklyProgress.axisLeft
        leftAxis.apply {
            axisMaximum = 13f
            axisMinimum = 0f
            textColor = resources.getColor(R.color.textPrimary)
            typeface = poppinsBold
            textSize = 11f
            setDrawAxisLine(false)
            setDrawZeroLine(false)
            setDrawGridLines(true)
        }

        val xAxis = binding.lineChartWeeklyProgress.xAxis
        xAxis.apply {
            position = XAxis.XAxisPosition.BOTTOM
            textColor = resources.getColor(R.color.textPrimary)
            typeface = poppinsMedium
            setDrawGridLines(true)
            setDrawGridLines(false)
            valueFormatter = LineChartValueFormatter()
        }

        val yAxisValues = arrayListOf<Entry>()
        yAxisValues.apply {
            add(Entry(0f, hoursWorked[0]))
            add(Entry(1f, hoursWorked[1]))
            add(Entry(2f, hoursWorked[2]))
            add(Entry(3f, hoursWorked[3]))
            add(Entry(4f, hoursWorked[4]))
            add(Entry(5f, hoursWorked[5]))
            add(Entry(6f, hoursWorked[6]))
        }

        val lineDataSet = LineDataSet(yAxisValues, "DataSet1")
        lineDataSet.apply {
            axisDependency = YAxis.AxisDependency.LEFT
            setDrawCircles(true)
            circleRadius = 2.5f
            fillAlpha = 255
            color = ContextCompat.getColor(requireActivity(), R.color.primaryColor)
            fillColor = ContextCompat.getColor(requireActivity(), R.color.primaryColor)
            mode = LineDataSet.Mode.CUBIC_BEZIER
            setDrawFilled(true)
            setDrawCircleHole(false)
            setCircleColor(R.color.red)
            setDrawValues(false)
        }

        val lineData = LineData(lineDataSet)
        lineData.setDrawValues(false)

        binding.lineChartWeeklyProgress.data = lineData
    }

    private fun initWorkOverview(summary: Summary) {
        val workOverviewsAdapter = WorkOverviewAdapter(summary.categories!!)
        binding.recyclerviewWorkOverview.adapter = workOverviewsAdapter
    }

    private fun initProjects(summary: Summary) {
        val projectsAdapter = ProjectsAdapter(summary.projects!!)
        binding.recyclerviewProjects.adapter = projectsAdapter
    }

    private fun initLanguages(summary: Summary) {
        val languageAdapter = LanguagesAdapter(summary.languages!!)
        binding.recyclerviewLanguage.adapter = languageAdapter
    }


    private fun setFullScreen(setFullScreen: Boolean = true) {
        if (setFullScreen) requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        else requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    override fun onLoading() {
        Timber.e("Loading...")
    }

    override fun onSuccess(message: String?) {
        //Timber.e(message)
    }

    override fun onError(exception: Exception, message: String?) {
        Timber.e("Error: $exception")
    }

}