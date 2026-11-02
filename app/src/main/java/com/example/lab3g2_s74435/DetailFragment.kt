package com.example.lab3g2_s74435

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    override fun onAttach(context: Context) { super.onAttach(context); Log.d("LC_Detail", "onAttach") }
    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState); Log.d("LC_Detail", "onCreate") }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("LC_Detail", "onCreateView")
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("LC_Detail", "onViewCreated")

        // Ambil data itemId yang dihantar (default 0 jika tiada)
        val itemId = arguments?.getInt("itemId") ?: 0

        // Cari TextView dalam fragment_detail.xml dan paparkan itemId
        val tvDisplayId = view.findViewById<android.widget.TextView>(R.id.tvDisplayId)
        tvDisplayId.text = "Item ID received: $itemId"
    }

    override fun onStart() { super.onStart(); Log.d("LC_Detail", "onStart") }
    override fun onResume() { super.onResume(); Log.d("LC_Detail", "onResume") }
    override fun onPause() { super.onPause(); Log.d("LC_Detail", "onPause") }
    override fun onStop() { super.onStop(); Log.d("LC_Detail", "onStop") }
    override fun onDestroyView() { super.onDestroyView(); Log.d("LC_Detail", "onDestroyView") }
    override fun onDestroy() { super.onDestroy(); Log.d("LC_Detail", "onDestroy") }
    override fun onDetach() { super.onDetach(); Log.d("LC_Detail", "onDetach") }
}
