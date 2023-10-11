package id.synergy.activitybase.ui
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.synergy.activitybase.R
import id.synergy.activitybase.adapter.CategoryAdapter
import id.synergy.activitybase.data.categoryMovieList
import id.synergy.activitybase.databinding.ActivityHomeBinding
import id.synergy.activitybase.ui.DetailActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var _binding : ActivityHomeBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var currentAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        val toolbar = _binding.toolbar

        toolbar.title = "Category Movie"
        val color = R.color.white
        toolbar.setTitleTextColor(getColor(color))
        setSupportActionBar(toolbar)

        recyclerView = _binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        currentAdapter = CategoryAdapter(categoryMovieList) { items ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putParcelableArrayListExtra("dataModel", items.listMovie)
            intent.putExtra("category",items.title)
            startActivity(intent)
        }
        recyclerView.adapter = currentAdapter
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
