package id.synergy.activitybase.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.synergy.activitybase.R
import id.synergy.activitybase.adapter.CategoryAdapter
import id.synergy.activitybase.adapter.MovieAdapter
import id.synergy.activitybase.data.MovieModel
import id.synergy.activitybase.data.categoryMovieList
import id.synergy.activitybase.databinding.ActivityDetailBinding
import id.synergy.activitybase.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var _binding : ActivityDetailBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var currentAdapter: RecyclerView.Adapter<*>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        val receivedMovieList = intent.getParcelableArrayListExtra<MovieModel>("dataModel")
        val category = intent.getStringExtra("category")
        val recyclerView = _binding.recyclerView
        if(receivedMovieList != null){
            recyclerView.layoutManager = GridLayoutManager(this, 2)
            currentAdapter = MovieAdapter(receivedMovieList) { items ->
                val searchUrl = "https://www.google.com/search?q=${items.title}"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(searchUrl)
                startActivity(intent)
            }
            recyclerView.adapter = currentAdapter
        }
        val toolbar = _binding.toolbar
        val color = R.color.white
        toolbar.setTitleTextColor(getColor(color))
        toolbar.title = category
        setSupportActionBar(toolbar)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.list -> {
                recyclerView.layoutManager = LinearLayoutManager(this)
                currentAdapter = CategoryAdapter(categoryMovieList) { item ->
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putParcelableArrayListExtra("dataModel", item.listMovie)
                    startActivity(intent)
                }
                recyclerView.adapter = currentAdapter
                return true
            }
            R.id.grid -> {
                recyclerView.layoutManager = GridLayoutManager(this, 2)
                currentAdapter = CategoryAdapter(categoryMovieList) { items ->
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putParcelableArrayListExtra("dataModel", items.listMovie)
                    startActivity(intent)
                }
                recyclerView.adapter = currentAdapter
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}