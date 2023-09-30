package id.synergy.tipcount

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import id.synergy.tipcount.databinding.FragmentSplashScreenBinding

class SplashScreen : Fragment() {
    private var binding : FragmentSplashScreenBinding? = null
    private val _binding get() = binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashScreenBinding.inflate(layoutInflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, TipCountFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }, 3000)
    }

}