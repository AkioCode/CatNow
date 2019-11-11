package com.example.catnow

import com.google.gson.annotations.SerializedName

data class Cat(
    @SerializedName("id")
    var id: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("height")
    var height: Int,
    @SerializedName("width")
    var width: Int
)