package com.app.walkin.api.repository

import com.app.walkin.base.BaseActivity
import com.app.walkin.constants.ApiService
import com.app.walkin.model.CustomerHomeModel

class CustomerHomeRepository(
private val movieApiService:ApiService,
private val baseActivity: BaseActivity?
) : BaseRepository(baseActivity, movieApiService) {

    suspend fun getCustomerHome(showBlockingLoader: Boolean): CustomerHomeModel {
        return doSafeAPIRequest(
            call = { movieApiService.getMovies() },
            showBlockingLoader = showBlockingLoader
        )
    }
}