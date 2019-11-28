package com.ak.livedatasample.service

import com.ak.livedatasample.BuildConfig.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    private lateinit var retrofit: Retrofit
     fun getApiService(): RestApiService{
        retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RestApiService::class.java)
    }
}