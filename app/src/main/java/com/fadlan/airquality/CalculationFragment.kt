package com.fadlan.airquality

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class CalculationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_calculation, container, false)
        val bmibtn = view.findViewById<ImageButton>(R.id.bmibtn)
        val suhubtn = view.findViewById<ImageButton>(R.id.suhubtn)

        bmibtn.setOnClickListener {
            loadBmiFragment()
        }

        suhubtn.setOnClickListener {
            loadConverterFragment()
        }

        return view
    }

    private fun loadBmiFragment() {
        val bmiFragment = BmiFragment()
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.calculation, bmiFragment) // Sesuaikan dengan ID yang ada dalam layout Anda
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun loadConverterFragment() {
        val converterFragment = ConverterFragment()
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.calculation, converterFragment) // Sesuaikan dengan ID yang ada dalam layout Anda
        transaction.addToBackStack(null)
        transaction.commit()
    }


}
