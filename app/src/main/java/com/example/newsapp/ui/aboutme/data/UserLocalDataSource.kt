package com.example.newsapp.ui.aboutme.data

import com.example.newsapp.R
import com.example.newsapp.model.UserProfileEntity
import com.example.newsapp.model.UserProfileSocialNetworkEntity
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserLocalDataSource @Inject constructor() {

    fun getUserProfile() = flow {
        emit(
            UserProfileEntity(
                image = R.drawable.ic_launcher_foreground,
                fullName = R.string.label_full_name,
                socialNetwork = ArrayList<UserProfileSocialNetworkEntity>().apply {
                    add(
                        UserProfileSocialNetworkEntity(
                            title = R.string.label_github,
                            link = R.string.link_github
                        )
                    )
                    add(
                        UserProfileSocialNetworkEntity(
                            title = R.string.label_linkedin,
                            link = R.string.link_linkedin
                        )
                    )
                }
            )
        )
    }
}
