package com.example.lab3g2_s74435

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : LoggingActivity() {
    private val viewModel: CountViewModel by viewModels()
    private val prefs by lazy {
        getSharedPreferences("lab", MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lifecycle.addObserver(LogObserver())

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                ticker().collect {
                    Log.d("LC_FLOW", "tick $it")
                }
            }
        }

        viewModel.count = prefs.getInt("saved", 0)

        Log.d(
            "LC_PREF",
            "saved=${prefs.getInt("saved", -1)}"
        )
    }

    override fun onStop() {
        super.onStop()
        prefs.edit().putInt("saved", viewModel.count).apply()
    }

    private fun ticker() = flow {
        var i = 0
        while (true) {
            emit(i++)
            delay(1000)
        }
    }
}
