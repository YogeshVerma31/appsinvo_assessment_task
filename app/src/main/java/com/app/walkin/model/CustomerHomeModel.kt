package com.app.walkin.model

import com.app.walkin.viewmodel.ItemViewModel
import com.google.gson.annotations.SerializedName

data class CustomerHomeModel(
    @SerializedName("data")
    val data: Data,
    @SerializedName("errorCode")
    val errorCode: String,
    @SerializedName("errorMsg")
    val errorMsg: String
)

data class Data(
    @SerializedName("banners")
    val banners: MutableList<Banner>,
    @SerializedName("categories")
    val categories: MutableList<Category>
)

data class Banner(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String
)


data class Category(
    @SerializedName("icon")
    val icon: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_subcat")
    val is_subcat: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String
): ItemViewModel()