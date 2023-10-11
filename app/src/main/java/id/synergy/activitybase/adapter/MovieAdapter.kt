package id.synergy.activitybase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.synergy.activitybase.data.DataCategoryMovieModel
import id.synergy.activitybase.databinding.ItemCardViewBinding

class MovieAdapter(private val data: List<DataCategoryMovieModel>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemCardViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.binding.titleTextView.text = item.title
        holder.binding.subtitleTextView.text = item.subtitle
        Glide
            .with(holder.binding.imageView)
            .load(item.image)
            .centerCrop()
            .into(holder.binding.imageView);
    }

    override fun getItemCount() = data.size
}
