package com.app.walkin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.app.walkin.viewholders.MultiViewHolder
import com.app.walkin.viewmodel.ItemViewModel

class MultiAdapter<T : ItemViewModel>(@LayoutRes val layoutId: Int) :
    RecyclerView.Adapter<MultiViewHolder<T>>() {
    val list: MutableList<T> = mutableListOf()
    var listFiltered: MutableList<T> = list

    private var onClickListener: Any? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiViewHolder<T> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            layoutInflater,
            layoutId, parent, false
        )
        return MultiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MultiViewHolder<T>, position: Int) {
        val itemViewModel = list[position]
        this.onClickListener?.let { itemViewModel.onClickListener = it }
        holder.bind(itemViewModel)

    }

    override fun getItemCount(): Int {
        return if (list.size < 10) list.size else 10
    }

    fun getItems(): MutableList<T> {
        return list as MutableList<T>
    }

    fun addItems(itemList: MutableList<T>) {
        addItems(itemList, true)
    }

    fun setOnClickListener(onClickListener: Any?) {
        this.onClickListener = onClickListener
    }


    fun addItems(itemList: MutableList<T>, notifyDataSetChanged: Boolean) {
        val start = list.size
        list.addAll(itemList)
        if (notifyDataSetChanged)
            notifyItemRangeInserted(start, itemList.size)

    }

}