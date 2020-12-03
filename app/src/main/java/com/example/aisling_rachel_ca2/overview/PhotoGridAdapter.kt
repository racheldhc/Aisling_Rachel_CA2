package com.example.aisling_rachel_ca2.overview


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.aisling_rachel_ca2.databinding.GridViewItemBinding
import com.example.aisling_rachel_ca2.network.ShoppingItem

class PhotoGridAdapter(val onClickListener: OnClickListener) : ListAdapter<ShoppingItem, PhotoGridAdapter.ShoppingItemViewHolder>(DiffCallback) {

    class ShoppingItemViewHolder(private var binding: GridViewItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(shoppingItem: ShoppingItem) {
            binding.item = shoppingItem
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ShoppingItem>() {
        override fun areItemsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
            return oldItem.name == newItem.name
        }
    }

    class OnClickListener(val clickListener: (shoppingItem: ShoppingItem) -> Unit) {
        fun onClick(shoppingItem: ShoppingItem) = clickListener(shoppingItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ShoppingItemViewHolder {
        return ShoppingItemViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        val shoppingItem = getItem(position)
        holder.bind(shoppingItem)

        holder.itemView.setOnClickListener {
            onClickListener.onClick(shoppingItem)
        }
    }
}