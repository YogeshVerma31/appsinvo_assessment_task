package com.app.walkin.screens.fragments

import addFragmentWithFadeInNoStack
import android.graphics.Point
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.walkin.R
import com.app.walkin.base.BaseActivity
import com.app.walkin.base.BaseFragment
import com.app.walkin.databinding.FragmentMainBinding
import com.app.walkin.viewmodel.CustomerHomeViewModel

class MainFragment : BaseFragment() {

    companion object {
        var TAG = BaseFragment::class.java.simpleName

        fun getInstance(): MainFragment {
            return MainFragment()
        }
    }

    private lateinit var _viewBinder: FragmentMainBinding
    private lateinit var customerHomeViewModel: CustomerHomeViewModel

    private var homeFragment :HomeFragment?=null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinder = FragmentMainBinding.inflate(inflater, container, false)
        return _viewBinder.root
    }

    override fun initViewModels() {

    }

    override fun onViewClick(view: View?) {

    }

    override fun initView(view: View) {
        _viewBinder.homeBottomNavigation.selectedItemId = R.id.btnHome
        homeFragment = HomeFragment.getInstance()
        parentFragmentManager.addFragmentWithFadeInNoStack(R.id.flBottomContainer,homeFragment!!)

    }

    override fun setListeners() {

        _viewBinder.homeBottomNavigation.setOnNavigationItemSelectedListener {
            var id = it.itemId
            when(it.itemId){
                R.id.btnProfile ->{

                   setImageWithAnmation(R.id.btnProfile,R.drawable.float_profile)
                }

                R.id.btnMyBooking ->{
                    setImageWithAnmation(R.id.btnMyBooking,R.drawable.float_home)

                }
                R.id.btnScanQr ->{
                    setImageWithAnmation(R.id.btnScanQr,R.drawable.float_scan_qr)

                }
                R.id.btnHome ->{
                    setImageWithAnmation(R.id.btnHome,R.drawable.float_home)


                }
                R.id.btnMyQR ->{
                    setImageWithAnmation(R.id.btnMyQR,R.drawable.float_my_qr)
                }
            }
            true
        }

    }

    private fun setImageWithAnmation(id:Int,image: Int){
        var view = _viewBinder.homeBottomNavigation.findViewById<View>(id)
        _viewBinder.ivFloat.setImageResource(image)
        _viewBinder.ivFloat.animate().x(getPointOfView(view).x.toFloat()).setDuration(600L).start()
    }


    private fun getPointOfView(view: View?,):Point{
        var location = IntArray(2)
        view?.getLocationInWindow(location)
        return Point(location[0],location[1])
    }

    override fun setObservers() {

    }

}