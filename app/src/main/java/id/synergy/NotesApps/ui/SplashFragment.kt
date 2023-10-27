package id.synergy.NotesApps.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.postDelayed
import androidx.navigation.fragment.findNavController
import id.synergy.fragmentbase.R
import id.synergy.NotesApps.data.SessionManager
import id.synergy.fragmentbase.databinding.FragmentSplashBinding
import id.synergy.fragmentbase.ui.SplashFragmentDirections

class SplashFragment : Fragment() {
    private var _binding : FragmentSplashBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(layoutInflater, container,false)

        val sessionManager = SessionManager(requireContext())
        Handler(Looper.getMainLooper()).postDelayed({
            if(sessionManager.getLoginStatus()){
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
            }else{
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToWelcomeFragment())

            }
        },3000)
        return binding.root
    }

}