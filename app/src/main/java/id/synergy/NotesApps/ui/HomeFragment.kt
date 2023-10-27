package id.synergy.NotesApps.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.synergy.fragmentbase.R
import id.synergy.NotesApps.adapter.CategoryAdapter
import id.synergy.NotesApps.data.MovieModel
import id.synergy.NotesApps.data.categoryMovieList
import id.synergy.fragmentbase.databinding.FragmentHomeBinding
import id.synergy.fragmentbase.ui.HomeFragmentDirections

class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var currentAdapter: RecyclerView.Adapter<*>
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        setupToolbar()
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        currentAdapter = CategoryAdapter(categoryMovieList) { items ->
            val toDetailFragment = HomeFragmentDirections.actionHomeFragmentToDetailFragment()
            toDetailFragment.data = (items.listMovie.toTypedArray())
            toDetailFragment.categoryName = items.title
            findNavController().navigate(toDetailFragment)
        }
        recyclerView.adapter = currentAdapter

        return view
    }
    private fun setupToolbar(){
        val toolbar = binding.toolbar
        toolbar.title = "Category Movie"
        val color = R.color.white
        toolbar.setTitleTextColor(requireContext().getColor(color))
        toolbar.inflateMenu(R.menu.main_menu)
        toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.list -> {
                    recyclerView.layoutManager = LinearLayoutManager(requireContext())
                    currentAdapter = CategoryAdapter(categoryMovieList) { items ->
                        val toDetailFragment =
                            HomeFragmentDirections.actionHomeFragmentToDetailFragment()
                        toDetailFragment.data = (items.listMovie.toTypedArray())
                        findNavController().navigate(toDetailFragment)
                    }
                    recyclerView.adapter = currentAdapter
                }
                R.id.grid -> {
                    recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
                    currentAdapter = CategoryAdapter(categoryMovieList) { items ->
                        val toDetailFragment =
                            HomeFragmentDirections.actionHomeFragmentToDetailFragment()
                        toDetailFragment.data = (items.listMovie.toTypedArray())
                        findNavController().navigate(toDetailFragment)
                    }
                    recyclerView.adapter = currentAdapter
                }
            }
            true
        }
    }
    fun navigation(movieList : ArrayList<MovieModel>){

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}