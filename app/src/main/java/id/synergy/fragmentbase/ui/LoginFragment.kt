package id.synergy.fragmentbase.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.synergy.fragmentbase.R
import id.synergy.fragmentbase.databinding.FragmentLoginBinding
import id.synergy.fragmentbase.databinding.FragmentWelcomeBinding

class LoginFragment : Fragment() {
    private var binding : FragmentLoginBinding? = null
    private val _binding get() = binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater,container,false)
        return _binding.root
    }
    private fun textWatcher(){
        _binding.edtEmail.addTextChangedListener(object  : TextWatcher {
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