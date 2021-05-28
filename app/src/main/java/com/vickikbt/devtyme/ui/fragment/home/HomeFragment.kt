package com.vickikbt.devtyme.ui.fragment.home

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.vickikbt.devtyme.R
import com.vickikbt.devtyme.databinding.FragmentHomeBinding
import com.vickikbt.devtyme.models.Project
import com.vickikbt.devtyme.utils.Helpers.getTimeOfDay
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

        setFullScreen(false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    @SuppressLint("SetTextI18n")
    private fun initUI() {
        binding.imageViewProfilePic.setOnClickListener { viewModel.revokeToken() }

        val greetingMessage = getTimeOfDay()
        viewModel.currentUser.observe(viewLifecycleOwner) { user ->
            binding.textViewGreeting.text =
                "$greetingMessage ${user.displayName?.getDisplayName()}."
            Glide.with(this).load(user.photo).circleCrop().into(binding.imageViewProfilePic)
        }

        viewModel.summary.observe(viewLifecycleOwner) { summary ->

            Timber.e("Summary: $summary")

            summary.forEach {
                getDailyGoalProgress(it.projects!!)
            }
        }

        val userDailyGoal = 10
        val userDailyProgress = 6

        binding.progressBarDailyWorkProgress.max = userDailyGoal
        ObjectAnimator.ofInt(binding.progressBarDailyWorkProgress, "progress", userDailyProgress)
            .setDuration(animationDuration.toLong())
            .start()
    }

    private fun initPieChartUI() {
        binding.piechartTodaysProgress.setEntryLabelTextSize(16f)
        binding.piechartTodaysProgress.setCenterTextColor(Color.WHITE)
        binding.piechartTodaysProgress.setHoleColor(Color.TRANSPARENT)
        //binding.piechartTodaysProgress.centerText = "Projects"
        binding.piechartTodaysProgress.setCenterTextSize(24f)
        binding.piechartTodaysProgress.description.isEnabled = false

        val legend: Legend = binding.piechartTodaysProgress.legend
        legend.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
        legend.orientation = Legend.LegendOrientation.HORIZONTAL
        legend.textColor=Color.WHITE
        legend.textSize=14f
        legend.setDrawInside(false)
        legend.isEnabled = true
    }

    private fun getDailyGoalProgress(projects: List<Project>) {
        initPieChartUI()

        val chartEntries = mutableListOf<PieEntry>()
        val chartColors = mutableListOf<Int>()
        projects.forEach {
            chartEntries.add(PieEntry(it.hours!!.toFloat(), it.name))
        }

        for (color in ColorTemplate.MATERIAL_COLORS) {
            chartColors.add(color)
        }

        for (color in ColorTemplate.VORDIPLOM_COLORS) {
            chartColors.add(color)
        }

        val pieDataSet = PieDataSet(chartEntries, "Projects")
        pieDataSet.colors = chartColors

        val pieData = PieData(pieDataSet)
        pieData.setDrawValues(true)
        //pieData.setValueTextSize(12f)
        pieData.setValueTextColor(Color.WHITE)

        binding.piechartTodaysProgress.data = pieData
        binding.piechartTodaysProgress.invalidate()

        binding.piechartTodaysProgress.animateY(animationDuration, Easing.EaseInQuad)
    }

    /*private fun getTodaysProgress() {
        val donutChart=requireActivity().findViewById<DonutChartView>(R.id.todays_progress_donut_view)

        val donutSet = listOf(
            20f,
            80f,
            100f
        )

        donutChart.donutColors = intArrayOf(
            Color.parseColor("#FFFFFF"),
            Color.parseColor("#9EFFFFFF"),
            Color.parseColor("#8DFFFFFF")
        )

        donutChart.animation.duration = animationDuration
        donutChart.show(donutSet)
    }*/

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