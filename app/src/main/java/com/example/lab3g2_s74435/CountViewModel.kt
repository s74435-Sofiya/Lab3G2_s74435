package com.example.lab3g2_s74435

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class CountViewModel(private val state: SavedStateHandle) : ViewModel() {

    var count: Int
        get() = state["count"] ?: 0
        set(value) {
            state["count"] = value
        }

    init {
        Log.d("LC_VM", "ViewModel created")
    }

    override fun onCleared() {
        Log.d("LC_VM", "ViewModel destroyed")
    }
}