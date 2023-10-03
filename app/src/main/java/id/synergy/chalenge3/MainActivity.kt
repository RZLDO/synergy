package id.synergy.chalenge3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.synergy.chalenge3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var _binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .commit();
    }
}