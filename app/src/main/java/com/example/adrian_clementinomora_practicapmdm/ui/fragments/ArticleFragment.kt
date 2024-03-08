package com.example.adrian_clementinomora_practicapmdm.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.adrian_clementinomora_practicapmdm.R
import com.example.adrian_clementinomora_practicapmdm.databinding.FragmentArticleBinding
import com.example.adrian_clementinomora_practicapmdm.ui.MainActivity
import com.example.adrian_clementinomora_practicapmdm.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar


class ArticleFragment : Fragment(R.layout.fragment_article) {

   lateinit var newsViewModel: NewsViewModel
   val args: ArticleFragmentArgs by navArgs()
    lateinit var  binding: FragmentArticleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)

        newsViewModel = (activity as MainActivity).newsViewModel
        val article = args.article

        binding.webView.apply {
            webViewClient = WebViewClient()
            article.url?.let {
                loadUrl(it)
            }
        }

        binding.fab.setOnClickListener {
            newsViewModel.addToFavourites(article)
            Snackbar.make(view, "Added to favourites", Snackbar.LENGTH_SHORT).show()
        }
    }
}