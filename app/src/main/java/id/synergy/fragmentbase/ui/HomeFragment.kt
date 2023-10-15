package id.synergy.fragmentbase.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.synergy.fragmentbase.R
import id.synergy.fragmentbase.adapter.CategoryAdapter
import id.synergy.fragmentbase.data.categoryMovieList
import id.synergy.fragmentbase.databinding.FragmentHomeBinding

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

        val toolbar = binding.toolbar
        toolbar.title = "Category Movie"
        val color = R.color.white
        toolbar.setTitleTextColor(requireContext().getColor(color))
        setHasOptionsMenu(true)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        currentAdapter = CategoryAdapter(categoryMovieList) { items ->

        }
        recyclerView.adapter = currentAdapter

        return view
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.list -> {
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
                currentAdapter = CategoryAdapter(categoryMovieList) { items ->

                }
                recyclerView.adapter = currentAdapter
                return true
            }
            R.id.grid -> {
                recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
                currentAdapter = CategoryAdapter(categoryMovieList) { items ->

                }
                recyclerView.adapter = currentAdapter
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}