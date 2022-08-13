package com.app.walkin.viewmodel

import androidx.lifecycle.MutableLiveData
import com.app.walkin.api.repository.CustomerHomeRepository
import com.app.walkin.api.services.BaseCloudAPIService
import com.app.walkin.base.BaseActivity
import com.app.walkin.constants.ApiService
import com.app.walkin.model.CustomerHomeModel
import kotlinx.coroutines.launch

class CustomerHomeViewModel(baseActivity: BaseActivity?):BaseViewModel() {

    private val customerHomeRepository = CustomerHomeRepository(
        BaseCloudAPIService.getApiService(ApiService::class.java),
        baseActivity
    )

    internal val customerHomeListLiveData = MutableLiveData<CustomerHomeModel>()

    fun getCustomerHome(showBlockingLoader: Boolean) {
        scope.launch {
            try {
                customerHomeListLiveData.postValue(customerHomeRepository.getCustomerHome(showBlockingLoader))
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }

    }
}