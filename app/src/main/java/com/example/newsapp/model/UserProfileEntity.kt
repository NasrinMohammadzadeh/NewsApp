package com.example.newsapp.model

data class UserProfileEntity(
    val image: Int,
    val fullName: Int,
    val socialNetwork: List<UserProfileSocialNetworkEntity>
)
