package com.example.newsapp.ui.aboutme

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.ItemAboutMeSocialNetworkBinding
import com.example.newsapp.model.UserProfileSocialNetworkEntity

class AboutMeSocialNetworkAdapter(private val itemClickCallBack: (UserProfileSocialNetworkEntity) -> Unit) :
    ListAdapter<UserProfileSocialNetworkEntity, AboutMeSocialNetworkAdapter.UserProfileSocialNetworkViewHolder>(
        object : DiffUtil.ItemCallback<UserProfileSocialNetworkEntity>() {
            override fun areItemsTheSame(
                oldItem: UserProfileSocialNetworkEntity,
                newItem: UserProfileSocialNetworkEntity
            ): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(
                oldItem: UserProfileSocialNetworkEntity,
                newItem: UserProfileSocialNetworkEntity
            ): Boolean {
                return oldItem == newItem
            }
        }
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserProfileSocialNetworkViewHolder {
        val view = ItemAboutMeSocialNetworkBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserProfileSocialNetworkViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserProfileSocialNetworkViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class UserProfileSocialNetworkViewHolder(private val binding: ItemAboutMeSocialNetworkBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: UserProfileSocialNetworkEntity) {
            binding.item = item
            binding.root.setOnClickListener {
                itemClickCallBack.invoke(item)
            }
        }
    }
}
