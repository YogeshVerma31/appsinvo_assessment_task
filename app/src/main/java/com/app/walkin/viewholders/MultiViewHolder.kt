package com.app.walkin.viewholders

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.app.walkin.BR
import com.app.walkin.viewmodel.ItemViewModel

class MultiViewHolder<T : ItemViewModel>(val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(itemViewModel: T) {
       binding.setVariable(BR.model,itemViewModel)
    }

}