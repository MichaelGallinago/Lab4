package net.micg.lab4.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.micg.lab4.R
import net.micg.lab4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, RootFragment()).commit()
    }
}
