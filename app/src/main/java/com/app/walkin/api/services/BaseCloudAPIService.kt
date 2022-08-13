package com.app.walkin.api.services


import com.app.walkin.AppController
import com.app.walkin.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

interface BaseCloudAPIService {

    companion object{
        operator fun invoke():Retrofit{
            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }

        fun<T> getApiService(service: Class<T>):T{
            if(AppController.cloudApiService!=null){
                return AppController.cloudApiService!!.create(service)
            }else{
                throw Throwable("CloudApiService cannot be null")
            }
        }
    }


}