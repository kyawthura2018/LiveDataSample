package com.ak.livedatasample.repository

import android.app.Application
import android.telecom.Call
import androidx.lifecycle.MutableLiveData
import com.ak.livedatasample.model.Blog
import com.ak.livedatasample.model.BlogWrapper
import com.ak.livedatasample.service.RetrofitInstance
import retrofit2.Response

class BlogRepository(application: Application) {
    private var movies: ArrayList<Blog> = ArrayList()
    private var mutableLiveData: MutableLiveData<List<Blog>> = MutableLiveData()

    fun getMutableLiveData(): MutableLiveData<List<Blog>>{
        val apiService = RetrofitInstance().getApiService()
        val call = apiService.getPopularBlog().also {
            it.enqueue(object : retrofit2.Callback<BlogWrapper> {
                override fun onFailure(call: retrofit2.Call<BlogWrapper>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(
                    call: retrofit2.Call<BlogWrapper>,
                    response: Response<BlogWrapper>
                ) {
                    val mBlogWrapper = response.body()
                    if(mBlogWrapper?.mData != null)
                    {
                        movies = mBlogWrapper.mData as ArrayList<Blog>
                        mutableLiveData.value = movies
                    }
                }

            })
        }
        return mutableLiveData
    }
}