package com.fadlan.airquality

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.fadlan.airquality.databinding.ActivityHomeBinding
import com.fadlan.airquality.databinding.ActivityMainBinding

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.suhu -> replaceFragment(ConverterFragment())
                R.id.bmi -> replaceFragment(BmiFragment())
                R.id.profile -> replaceFragment(ProfileFragment())

                else->{

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTranscation = fragmentManager.beginTransaction()
        fragmentTranscation.replace(R.id.flFragment,fragment)
        fragmentTranscation.commit()
        }
}



