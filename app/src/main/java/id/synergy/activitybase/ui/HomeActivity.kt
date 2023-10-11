package id.synergy.activitybase.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import id.synergy.activitybase.R
import id.synergy.activitybase.adapter.MovieAdapter
import id.synergy.activitybase.data.categoryMovieList
import id.synergy.activitybase.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var _binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        val recyclerView = _binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MovieAdapter(categoryMovieList)
        recyclerView.adapter = adapter
    }
}