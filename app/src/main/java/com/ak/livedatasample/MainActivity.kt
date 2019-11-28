package com.ak.livedatasample

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.ak.livedatasample.model.Blog
import com.ak.livedatasample.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var mBlogAdapter: BlogAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        getPopularBlog()
        swiperefresh.setOnRefreshListener {
            getPopularBlog()
        }
    }

    fun getPopularBlog(){
        swiperefresh.isRefreshing = true
        mainViewModel.getAllBlog().observe(this, Observer {
            swiperefresh.isRefreshing = false
            prepareRecyclerView(it)
        })
    }

    private fun prepareRecyclerView(blogList: List<Blog>){
        mBlogAdapter = BlogAdapter(blogList)
        if(this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            blogRecyclerView.layoutManager = LinearLayoutManager(this)
        else
            blogRecyclerView.layoutManager = GridLayoutManager(this, 4)
        blogRecyclerView.itemAnimator = DefaultItemAnimator()
        blogRecyclerView.adapter = mBlogAdapter
        mBlogAdapter.notifyDataSetChanged()
    }
}
