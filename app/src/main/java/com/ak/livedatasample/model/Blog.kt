package com.ak.livedatasample.model

import com.google.gson.annotations.SerializedName

data class Blog (
    @SerializedName("author")
    var mAuthor: String,
    @SerializedName("description")
    var mDescription: String,
    @SerializedName("link")
    var mLink: String,
    @SerializedName("pubDate")
    var mPubDate: String,
    @SerializedName("thumbnail")
    var mThumbnail: String,
    @SerializedName("title")
    var mTitle: String
)