package com.example.newsapp

import android.os.Bundle
import android.view.View
import com.example.newsapp.databinding.FragmentNewsListBinding
import com.example.newsapp.util.base.BaseFragment

class NewsListFragment : BaseFragment<FragmentNewsListBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_news_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

        binding.apply {

//            toolbar.root.setOnClickListener {
//                onScrollToTop()
//            }
//
//            toolbar.ivBack.setOnClickListener {
//                mainHelper.goBack()
//            }
        }
    }

}