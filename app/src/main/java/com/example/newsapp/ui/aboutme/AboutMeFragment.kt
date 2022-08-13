package com.example.newsapp.ui.aboutme

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentAboutMeBinding
import com.example.newsapp.ui.aboutme.viewmodel.UserProfileViewModel
import com.example.newsapp.util.base.BaseFragment
import com.example.newsapp.util.disableAnimationChanges
import com.example.newsapp.util.scrollToTop
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AboutMeFragment : BaseFragment<FragmentAboutMeBinding>() {
    private val viewModel by viewModels<UserProfileViewModel>()

    private lateinit var userProfileSocialNetworkAdapter: AboutMeSocialNetworkAdapter

    override val layoutId: Int
        get() = R.layout.fragment_about_me

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initValue()
        initView()
        initObservation()
    }

    private fun initValue() {}

    private fun initView() {

        binding.apply {

            ivTheme.setOnClickListener {
                mainHelper.changeTheme()
            }

//            btnAboutMe.setOnClickListener {
//                mainHelper.navigate(AboutMeFragment.actionUserProfileFragmentToAboutMeSheet())
//            }
        }

        initRecyclerView()
    }

    private fun initObservation() {

        lifecycleScope.launch {

            viewModel.userProfile.collect {
                binding.userProfile = it
                userProfileSocialNetworkAdapter.submitList(it.socialNetwork)
            }

            viewModel.getIsDarkThemeFlow.collect {
                binding.isDarkTheme = it
            }
        }
    }

    private fun initRecyclerView() {

        userProfileSocialNetworkAdapter = AboutMeSocialNetworkAdapter {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(getString(it.link))))
        }

        binding.rvSocialNetwork.apply {
            disableAnimationChanges()
            adapter = userProfileSocialNetworkAdapter
        }
    }

    override fun onScrollToTop() {
        binding.apply {
            nsvUserProfile.scrollToTop()
        }
    }

}