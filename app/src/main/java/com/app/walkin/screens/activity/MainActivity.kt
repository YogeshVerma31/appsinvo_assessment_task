package com.app.walkin.screens.activity

import addFragmentWithFadeInNoStack
import android.os.Bundle
import android.view.View
import com.app.walkin.R
import com.app.walkin.base.BaseActivity
import com.app.walkin.databinding.ActivityMainBinding
import com.app.walkin.screens.fragments.MainFragment

class MainActivity : BaseActivity() {

    private val _viewBinder by lazy { ActivityMainBinding.inflate(layoutInflater) }


    private var mainFragment :MainFragment?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(_viewBinder.root)
    }

    override fun initViewModels() {
    }

    override fun initView() {
        mainFragment = MainFragment.getInstance()
        supportFragmentManager.addFragmentWithFadeInNoStack(R.id.flHomeContainer,mainFragment!!)

    }

    override fun setObservers() {

    }

    override fun setListeners() {
    }

    override fun onViewClick(view: View?) {

    }


}