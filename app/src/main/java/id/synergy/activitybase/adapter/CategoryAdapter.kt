package id.synergy.activitybase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.synergy.activitybase.data.DataCategoryMovieModel
import id.synergy.activitybase.databinding.ItemCardViewBinding

class CategoryAdapter(private val data: List<DataCategoryMovieModel>, private val itemClickListener: (DataCategoryMovieModel) -> Unit) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

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
