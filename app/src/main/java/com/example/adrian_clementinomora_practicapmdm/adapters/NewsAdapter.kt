package com.example.adrian_clementinomora_practicapmdm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.adrian_clementinomora_practicapmdm.R
import com.example.adrian_clementinomora_practicapmdm.models.Article

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val articleImage: ImageView = itemView.findViewById(R.id.articleImage)
        val articleSource: TextView = itemView.findViewById(R.id.articleSource)
        val articleTitle: TextView = itemView.findViewById(R.id.articleTitle)
        val articleDescription: TextView = itemView.findViewById(R.id.articleDescription)
        val articleDateTime: TextView = itemView.findViewById(R.id.articleDateTime)
    }

    private val differCallBack = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ArticleViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]

        Glide.with(holder.itemView).load(article.urlToImage).into(holder.articleImage)
        holder.articleSource.text = article.source?.name
        holder.articleTitle.text = article.title
        holder.articleDescription.text = article.description
        holder.articleDateTime.text = article.publishedAt

        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(article)
        }
    }

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }
}