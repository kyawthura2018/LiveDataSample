package com.ak.livedatasample

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ak.livedatasample.model.Blog
import com.bumptech.glide.Glide

class BlogAdapter(var blogList: List<Blog>): RecyclerView.Adapter<BlogAdapter.MyViewHolder>() {
    private val TAG = "BlogAdapter"
    private val mBlogList: List<Blog> = blogList

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val rItemView = itemView
         var ivThumbnail: ImageView
         var tvTitle: TextView
         var tvDescription: TextView
         var tvLink: TextView
        init {
            ivThumbnail = rItemView.findViewById(R.id.ivThumbnail)
            tvTitle = rItemView.findViewById(R.id.tvTitle)
            tvDescription = rItemView.findViewById(R.id.tvDescription)
            tvLink = rItemView.findViewById(R.id.tvLink)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.blog_item, parent, false))
    }

    override fun getItemCount(): Int {
        return mBlogList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val mBlog = mBlogList[position]
        Glide.with(holder.itemView.context)
            .load(mBlog.mThumbnail)
            .into(holder.ivThumbnail)
        holder.tvTitle.text = mBlog.mTitle
        holder.tvDescription.text = mBlog.mDescription
        holder.tvLink.text = mBlog.mLink
        holder.tvLink.setOnClickListener {
            try {
                val intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.addCategory(Intent.CATEGORY_BROWSABLE)
                intent.data = Uri.parse(mBlog.mLink)
                holder.itemView.context.startActivity(intent)
            }
            catch (ex: Exception)
            {
                Log.e(TAG, "onClick: Image url has error")
            }
        }
    }
}