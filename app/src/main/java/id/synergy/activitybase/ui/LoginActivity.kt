package id.synergy.activitybase.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import id.synergy.activitybase.data.SessionManager
import id.synergy.activitybase.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var _binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        _binding.btnLogin.isEnabled = false
        textWatcher()
        val sessionManager = SessionManager(this)
        _binding.btnLogin.setOnClickListener {
            val intent = Intent(this,HomeActivity::class.java)
            sessionManager.setLoginStatus(true)
            startActivity(intent)
            finish()
        }
    }
    private fun textWatcher(){
        _binding.edtEmail.addTextChangedListener(object  : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                emailValidation()
                enableOrDisableLoginButton() //
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })


        _binding.edtPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                passwordValidation()
                enableOrDisableLoginButton()
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }
    fun passwordValidation(){
        val password = _binding.edtPassword.text?.trim()

        if (password.isNullOrEmpty()) {
            _binding.edtPassword.error = "password is required "
        }else if (password.length <= 6){
            _binding.edtPassword.error = "password is required "
        } else {
            _binding.edtPassword.error = null
        }
    }
    fun emailValidation() {
        val email = _binding.edtEmail.text?.trim()
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        if (email.isNullOrEmpty()) {
            _binding.edtEmail.error = "Email is required"
        } else if (!email.matches(emailPattern.toRegex())) {
            _binding.edtEmail.error = "Invalid email address"
        } else {
            _binding.edtEmail.error = null
        }
    }
    fun enableOrDisableLoginButton() {
        val isEmailValid = _binding.edtEmail.error.isNullOrEmpty()
        val isPasswordValid = _binding.edtPassword.error.isNullOrEmpty()

        _binding.btnLogin.isEnabled = isEmailValid && isPasswordValid
    }
}
