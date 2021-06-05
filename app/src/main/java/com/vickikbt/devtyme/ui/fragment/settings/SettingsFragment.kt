package com.vickikbt.devtyme.ui.fragment.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.vickikbt.devtyme.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings_fragment, rootKey)
    }
}