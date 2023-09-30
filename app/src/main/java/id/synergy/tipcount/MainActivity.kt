package id.synergy.tipcount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.synergy.tipcount.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var _binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        supportFragmentManager.beginTransaction()
            .add(R.id.container, SplashScreen())
            .addToBackStack(null)
            .commit();
    }
}