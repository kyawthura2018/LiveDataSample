package com.ak.livedatasample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ak.livedatasample.model.Blog
import com.ak.livedatasample.repository.BlogRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var movieRepository: BlogRepository = BlogRepository(application)

    fun getAllBlog(): LiveData<List<Blog>>{
        return movieRepository.getMutableLiveData()
    }

}