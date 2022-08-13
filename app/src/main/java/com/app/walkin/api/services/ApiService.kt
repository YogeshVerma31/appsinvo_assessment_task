package com.app.walkin.constants


import com.app.walkin.api.services.BaseApiService
import com.app.walkin.model.CustomerHomeModel
import retrofit2.Response
import retrofit2.http.*

interface ApiService: BaseApiService {

    @GET(BaseAPIConstants.CUSTOMER_API_HOME)
    suspend fun getMovies():Response<CustomerHomeModel>


}