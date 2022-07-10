package com.example.customjalalicalendar

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View.INVISIBLE
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.customjalalicalendar.databinding.CalendarLayoutItemBinding

class CalendarAdapter : ListAdapter<Any, CalendarAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(
        val binding: CalendarLayoutItemBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: CalendarLayoutItemBinding = CalendarLayoutItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(getItem(position)) {
            "ش","ی","د","س","چ","پ","ج", -> {
                holder.binding.tv.textSize = 24f
                holder.binding.root.isClickable = false
            }
        }
        if (getItem(position).equals("space")) {
            holder.binding.tv.visibility = INVISIBLE
            holder.binding.root.isClickable = false
        }
        holder.binding.tv.text = getItem(position).toString()
        holder.binding.executePendingBindings()
    }

}

object diffUtil : DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return oldItem == newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return oldItem == newItem
    }

}

interface OnClick {
    fun onItemClicked(id: Int)
}
