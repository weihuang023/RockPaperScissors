package com.example.huang.rockpaperscissors;

import android.os.Bundle;
import android.preference.PreferenceActivity;

// Setting Menu Preference add Preferences From Resource
public class Prefs extends PreferenceActivity {
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}
