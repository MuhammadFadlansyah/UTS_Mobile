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


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BmiFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BmiFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var etHeight: EditText
    private lateinit var etWeight: EditText
    private lateinit var calculateBtn: Button
    private lateinit var bmiTv: TextView
    private lateinit var status: TextView
    private lateinit var reCalculate: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bmi, container, false)
        val etHeight = view.findViewById<EditText>(R.id.etHeight)
        val etWeight = view.findViewById<EditText>(R.id.etWeight)
        val calculateBtn = view.findViewById<Button>(R.id.calculate_btn)
        val bmiTv = view.findViewById<TextView>(R.id.bmi_tv)
        val status = view.findViewById<TextView>(R.id.status)
        val reCalculate = view.findViewById<Button>(R.id.ReCalculate)

        calculateBtn.setOnClickListener {
            if (etHeight.text.isNotEmpty() && etWeight.text.isNotEmpty()) {
                val height = (etHeight.text.toString()).toInt()
                val weight = (etWeight.text.toString()).toInt()

                val BMI = calculateBMI(height, weight)

                bmiTv.text = BMI.toString()
                bmiTv.visibility = View.VISIBLE

                if (BMI < 18.5) {
                    status.text = "Under Weight"
                } else if (BMI >= 18.5 && BMI < 24.9) {
                    status.text = "Healthy"
                } else if (BMI >= 24.9 && BMI < 30) {
                    status.text = "Overweight"
                } else if (BMI >= 30) {
                    status.text = "Suffering from Obesity"
                }

                status.visibility = View.VISIBLE
                reCalculate.visibility = View.VISIBLE
                calculateBtn.visibility = View.GONE

            } else {
                Toast.makeText(requireContext(), "Please enter valid height and weight", Toast.LENGTH_SHORT).show()
            }
        }

        reCalculate.setOnClickListener {
            resetEverything()
        }

        return view
    }

    // Function to reset all Text and EditText fields.
    private fun resetEverything() {
        calculateBtn.visibility = View.VISIBLE
        reCalculate.visibility = View.GONE
        etHeight.text.clear()
        etWeight.text.clear()
        status.text = " "
        bmiTv.text = " "
        status.visibility = View.GONE
    }

    private fun calculateBMI(height: Int, weight: Int): Float {
        val heightInMetre = height.toFloat() / 100
        val BMI = weight.toFloat() / (heightInMetre * heightInMetre)
        return BMI
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BmiFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
