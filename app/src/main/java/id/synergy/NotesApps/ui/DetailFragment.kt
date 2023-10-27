package id.synergy.NotesApps.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.utils.widget.MockView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.synergy.fragmentbase.R
import id.synergy.NotesApps.adapter.CategoryAdapter
import id.synergy.NotesApps.adapter.MovieAdapter
import id.synergy.NotesApps.data.MovieModel
import id.synergy.NotesApps.data.categoryMovieList
import id.synergy.fragmentbase.databinding.FragmentDetailBinding
import id.synergy.fragmentbase.ui.DetailFragmentArgs

class DetailFragment : Fragment() {
    private var _binding : FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var currentAdapter: RecyclerView.Adapter<*>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        val args = DetailFragmentArgs.fromBundle(requireArguments())
        val movieModel: List<MovieModel>? = args.data?.toList()
        val title  : String = args.categoryName
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        if(movieModel != null){
            currentAdapter = MovieAdapter(movieModel) { items ->
                openUrl(items.title)
            }
            setupToolbar(title = title ,movieModel)
        }

        recyclerView.adapter = currentAdapter

        return view
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun openUrl(url : String){
        val searchUrl = "https://www.google.com/search?q=${url}"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(searchUrl)
        startActivity(intent)
    }
    private fun setupToolbar(title : String, movieData : List<MovieModel>){
        val toolbar = binding.toolbar
        toolbar.title = title
        val color = R.color.white
        toolbar.setTitleTextColor(requireContext().getColor(color))
        toolbar.inflateMenu(R.menu.main_menu)
        toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.list -> {
                    recyclerView.layoutManager = LinearLayoutManager(requireContext())
                    currentAdapter = MovieAdapter(movieData) { items ->
                        openUrl(items.title)
                    }
                    recyclerView.adapter = currentAdapter
                }
                R.id.grid -> {
                    recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
                    currentAdapter = MovieAdapter(movieData) { items ->
                        openUrl(items.title)
                    }
                    recyclerView.adapter = currentAdapter
                }
            }
            true
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}