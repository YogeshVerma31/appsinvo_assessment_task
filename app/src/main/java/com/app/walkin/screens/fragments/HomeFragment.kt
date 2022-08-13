package com.app.walkin.screens.fragments

import android.media.Image
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.ViewPager
import com.app.walkin.R
import com.app.walkin.adapters.AdapterBannerSlider
import com.app.walkin.adapters.MultiAdapter
import com.app.walkin.base.BaseActivity
import com.app.walkin.base.BaseFragment
import com.app.walkin.databinding.FragmentHomeBinding
import com.app.walkin.listeners.OnClickListener
import com.app.walkin.model.Banner
import com.app.walkin.model.Category
import com.app.walkin.viewmodel.CustomerHomeViewModel

class HomeFragment : BaseFragment() {

    companion object {
        var TAG = BaseFragment::class.java.simpleName

        fun getInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    private lateinit var _viewBinder: FragmentHomeBinding
    private lateinit var customerHomeViewModel: CustomerHomeViewModel

    private lateinit var adapterBannerSlider: AdapterBannerSlider

    private lateinit var categoriesAdapter : MultiAdapter<Category>

    private var runnable: Runnable? = null
    private var handler = Handler()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinder = FragmentHomeBinding.inflate(inflater, container, false)
        return _viewBinder.root
    }

    override fun initViewModels() {
        customerHomeViewModel = getViewModel(
            fragment = this,
            viewModel = CustomerHomeViewModel(activity as BaseActivity),
            className = CustomerHomeViewModel::class.java
        )
        customerHomeViewModel.getCustomerHome(true)
    }

    override fun onViewClick(view: View?) {
        when(view?.id){
            R.id.ivClear-> _viewBinder.layoutStaySafe.clStaySafe.visibility = View.GONE
        }
    }

    override fun initView(view: View) {

    }

    override fun setListeners() {
        setOnClickListener(_viewBinder.layoutStaySafe.ivClear)
    }

    override fun setObservers() {
        customerHomeViewModel.customerHomeListLiveData.observe(this, {
            if (it.data != null) {
                _viewBinder.clHome.visibility = View.VISIBLE
                setBannerSlider(it.data.banners)
                setRecyclerView(it.data.categories)
            }
        })
    }


    private fun setRecyclerView(list: MutableList<Category>){
        categoriesAdapter = MultiAdapter(R.layout.item_categories)
        _viewBinder!!.rvHome.apply {
            adapter = categoriesAdapter
        }
        categoriesAdapter.addItems(list)
    }


    private fun setBannerSlider(list: MutableList<Banner>) {
        adapterBannerSlider = AdapterBannerSlider(activity!!, list)

        adapterBannerSlider.setItem(list)

        addBottomDots(_viewBinder.llDots, adapterBannerSlider.count, 0)
        _viewBinder.vpBanner.apply {
            adapter = adapterBannerSlider
            setCurrentItem(0)
        }

        _viewBinder.vpBanner.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                addBottomDots(_viewBinder.llDots, adapterBannerSlider.count, position)
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })

        startAutoSlider(adapterBannerSlider.count)
    }

    private fun startAutoSlider(count: Int) {
        runnable = Runnable {
            var pos: Int = _viewBinder.vpBanner.getCurrentItem()
            pos = pos + 1
            if (pos >= count) pos = 0
            _viewBinder.vpBanner.setCurrentItem(pos)
            handler.postDelayed(runnable!!, 3000)
        }
        handler.postDelayed(runnable!!, 3000)
    }


    private fun addBottomDots(llDots: LinearLayout, size: Int, current: Int) {
        var dots: Array<ImageView?> = arrayOfNulls(size)
        llDots.removeAllViews()
        for (i in dots.indices) {
            dots[i] = ImageView(context)
            val width_height = 20
            val params =
                LinearLayout.LayoutParams(ViewGroup.LayoutParams(width_height, width_height))
            params.setMargins(10, 10, 10, 10)
            dots[i]!!.layoutParams = params
            dots[i]!!.setImageResource(R.drawable.shape_circle_outline)
            llDots.addView(dots[i])
        }

        if (dots.size > 0) {
            dots[current]!!.setImageResource(R.drawable.shape_circle)
        }
    }


}