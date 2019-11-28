package com.ak.livedatasample.service

import com.ak.livedatasample.model.BlogWrapper
import retrofit2.http.GET
import retrofit2.Call

interface RestApiService {
    @GET("feed.json")
    fun getPopularBlog(): Call<BlogWrapper>
}