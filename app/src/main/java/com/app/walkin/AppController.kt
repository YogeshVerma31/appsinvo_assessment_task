package com.app.walkin

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.app.walkin.api.services.BaseCloudAPIService
import retrofit2.Retrofit

class AppController:Application() {
    companion object{
        val TAG:String = AppController::class.java.simpleName
        var appController:AppController? = null
        var cloudApiService: Retrofit? = null
    }

    override fun onCreate() {
        super.onCreate()
        appController = this
        cloudApiService = BaseCloudAPIService()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

    }
}