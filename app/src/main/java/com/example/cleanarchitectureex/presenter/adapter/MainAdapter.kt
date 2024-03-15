//package com.example.cleanarchitectureex.presenter.adapter
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView.ViewHolder
//import com.example.cleanarchitectureex.databinding.ItemBinding
//
//class MainAdapter : ListAdapter<Content, MainAdapter.MainViewHolder>(DIFF_UTIL) {
//    companion object {
//        val DIFF_UTIL = object : DiffUtil.ItemCallback<Content>() {
//            override fun areItemsTheSame(oldItem: Content, newItem: Content): Boolean {
//                return oldItem.id == newItem.id
//            }
//
//            override fun areContentsTheSame(oldItem: Content, newItem: Content): Boolean {
//                return oldItem == newItem
//            }
//        }
//    }
//
//    class MainViewHolder(private val binding: ItemBinding) : ViewHolder(binding.root) {
//        fun bind(item: Content, position: Int) {
//            binding.item = item
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
//        val binding =
//            ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return MainViewHolder((binding))
//    }
//
//    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
//        getItem(position)?.let {
//            holder.bind(it, position)
//        }
//    }
//}