package com.app.walkin.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.app.walkin.R
import com.app.walkin.databinding.ItemBannerSliderBinding
import com.app.walkin.model.Banner

class AdapterBannerSlider(activity: Activity, items: List<Banner>) : PagerAdapter() {

    var activity: Activity? = null
    var items: List<Banner>? = null

    init {
        this.activity = activity
        this.items = items
    }


    override fun getCount(): Int = items?.size!!


    fun setItem(items: List<Banner>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = LayoutInflater.from(container.context)
        val binding: ItemBannerSliderBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.item_banner_slider, container, false)
        binding.model = items?.get(position)
        container.addView(binding.root)
        return binding.root
    }


}