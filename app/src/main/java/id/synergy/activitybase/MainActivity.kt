package id.synergy.activitybase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import id.synergy.activitybase.data.SessionManager
import id.synergy.activitybase.databinding.ActivityMainBinding
import id.synergy.activitybase.ui.HomeActivity
import id.synergy.activitybase.ui.WelcomeActivity

class MainActivity : AppCompatActivity() {
    private lateinit var _binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        val handler = Handler()
        val sessionManager = SessionManager(this)
        handler.postDelayed({
            if(sessionManager.getLoginStatus()){
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000)
    }
}