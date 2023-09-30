package id.synergy.tipcount

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.synergy.tipcount.databinding.FragmentTipCountBinding



class TipCountFragment : Fragment() {
    private var _binding : FragmentTipCountBinding? = null
    private val binding get() = _binding!!
    var isRoundUp = false
    var tip = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentTipCountBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tipGroup.setOnCheckedChangeListener{ _, checkedId ->
            when(checkedId){
                R.id.option_twenty_percent->{
                    tip = 20
                }
                R.id.option_eighteen_percent->{
                    tip = 18
                }
                R.id.option_fifteen_percent->{
                    tip = 15
                }
            }
        }
        binding.roundUpSwitch.setOnCheckedChangeListener { _, isChecked->
            this.isRoundUp = isChecked
        }
        binding.calculateButton.setOnClickListener {
            calculate(tip = tip, isRoundUp = isRoundUp)
        }

    }
    private fun calculate(tip: Int, isRoundUp: Boolean){
        val cost : Int? = binding.edtCost.text.toString().toIntOrNull()

        if (cost != null) {
            val result: Double = if (isRoundUp) {
                (cost * tip / 100).toDouble()
            } else {
                cost * tip / 100.0
            }
            binding.tipResult.text = result.toString()
        }
    }
}