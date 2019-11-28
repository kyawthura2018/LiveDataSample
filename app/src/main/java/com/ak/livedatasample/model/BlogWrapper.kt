package com.ak.livedatasample.model

import com.google.gson.annotations.SerializedName

data class BlogWrapper (
    @SerializedName("data")
    var mData: List<Blog>,
    @SerializedName("error")
    var mError: Boolean,
    @SerializedName("message")
    var mMessage: String,
    @SerializedName("status")
    var mStatus: String
)