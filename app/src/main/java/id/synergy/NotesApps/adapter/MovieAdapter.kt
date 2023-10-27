package id.synergy.NotesApps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.synergy.NotesApps.data.MovieModel
import id.synergy.fragmentbase.databinding.ItemCardViewBinding

class MovieAdapter(private val data: List<MovieModel>, private val itemClickListener: (MovieModel) -> Unit) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemCardViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.binding.titleTextView.text = item.title
        Glide
            .with(holder.binding.imageView)
            .load(item.image)
            .centerCrop()
            .into(holder.binding.imageView)
        holder.itemView.setOnClickListener {
            itemClickListener(item)
        }
    }

    override fun getItemCount() = data.size
}
