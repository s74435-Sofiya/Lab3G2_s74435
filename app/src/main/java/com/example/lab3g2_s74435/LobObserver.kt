package com.example.lab3g2_s74435

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class LogObserver : DefaultLifecycleObserver {
    // This triggers automatically when the Activity enters the STARTED state (becomes visible)
    override fun onStart(owner: LifecycleOwner) {
        Log.d("LC_OBS", "start")
    }

    // This triggers automatically when the Activity enters the STOPPED state (goes to background)
    override fun onStop(owner: LifecycleOwner) {
        Log.d("LC_OBS", "stop")
    }
}
