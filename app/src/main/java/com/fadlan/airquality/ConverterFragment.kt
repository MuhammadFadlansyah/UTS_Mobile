package com.fadlan.airquality

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ConverterFragment : Fragment() {

    private lateinit var btTemp1: Button
    private lateinit var btTemp2: Button
    private lateinit var button: Button
    private lateinit var etTemp1: EditText
    private lateinit var tvTempValue: TextView

    companion object {
        const val c = "Celsius"
        const val f = "Fahrenheit"
        const val k = "Kelvin"
        const val r = "Reaumur"
    }

    private var temp1 = c
    private var temp2 = f

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_converter, container, false)
        btTemp1 = view.findViewById(R.id.btTemp1)
        btTemp2 = view.findViewById(R.id.btTemp2)
        etTemp1 = view.findViewById(R.id.etTemp1)
        button = view.findViewById(R.id.button)
        tvTempValue = view.findViewById(R.id.tvTempValue)
        initView()
        btTempClick()
        return view
    }

    private fun initView() {
        btTemp1.text = temp1
        btTemp2.text = temp2
        button.setOnClickListener {
            if (etTemp1.text.isNotEmpty()) {
                countTemp()
            } else {
                etTemp1.error = "Kosong"
                Toast.makeText(requireContext(), "Form harus di isi", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun btTempClick() {
        btTemp1.setOnClickListener {
            buildDialog(1)
        }

        btTemp2.setOnClickListener {
            buildDialog(2)
        }
    }

    private fun buildDialog(tempNum: Int) {
        val singleItems = arrayOf(c, f, k, r)

        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Pilih salah satu!")
            .setItems(singleItems) { dialog, which ->
                if (tempNum == 1) {
                    temp1 = singleItems[which]
                    btTemp1.text = temp1
                } else {
                    temp2 = singleItems[which]
                    btTemp2.text = temp2
                }
            }
            .show()
    }

    private fun countTemp() {
        val inputValue = etTemp1.text.toString().toDouble()
        var value: Double = 0.0

        when {
            temp1 == c && temp2 == f -> {
                value = ctof(inputValue)
            }
            temp1 == c && temp2 == r -> {
                value = ctor(inputValue)
            }
            temp1 == c && temp2 == k -> {
                value = ctok(inputValue)
            }
            temp1 == f && temp2 == c -> {
                value = ftoc(inputValue)
            }
            temp1 == f && temp2 == r -> {
                value = ftor(inputValue)
            }
            temp1 == f && temp2 == k -> {
                value = ftok(inputValue)
            }
            temp1 == r && temp2 == c -> {
                value = rtoc(inputValue)
            }
            temp1 == r && temp2 == f -> {
                value = rtof(inputValue)
            }
            temp1 == r && temp2 == k -> {
                value = rtok(inputValue)
            }
            temp1 == k && temp2 == c -> {
                value = ktoc(inputValue)
            }
            temp1 == k && temp2 == f -> {
                value = ktof(inputValue)
            }
            temp1 == k && temp2 == r -> {
                value = ktor(inputValue)
            }
            else -> {
                Toast.makeText(requireContext(), "Tidak dapat mengkonversi 2 temperatur yang sama", Toast.LENGTH_LONG).show()
            }
        }

        tvTempValue.text = value.toString()
    }

    private fun ctof(c: Double): Double {
        return c * (9.0 / 5.0) + 32.0
    }

    private fun ctor(c: Double): Double {
        return c * (4.0 / 5.0)
    }

    private fun ctok(c: Double): Double {
        return c + 273.15
    }

    private fun ftoc(f: Double): Double {
        return (f - 32.0) * (5.0 / 9.0)
    }

    private fun ftor(f: Double): Double {
        return (f - 32.0) * (4.0 / 9.0)
    }

    private fun ftok(f: Double): Double {
        return ((f - 32.0) * (5.0 / 9.0)) - 273.15
    }

    private fun rtoc(r: Double): Double {
        return r * (5.0 / 4.0)
    }

    private fun rtof(r: Double): Double {
        return r * (9.0 / 4.0) + 32.0
    }

    private fun rtok(r: Double): Double {
        return r * (5.0 / 4.0) + 273.15
    }

    private fun ktoc(k: Double): Double {
        return k - 273.15
    }

    private fun ktof(k: Double): Double {
        return (k - 273.15) * (9.0 / 5.0) + 32.0
    }

    private fun ktor(k: Double): Double {
        return (k - 273.15) * (4.0 / 5.0)
    }
}
