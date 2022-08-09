package com.example.blockgeminitasak.ui.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.viewbinding.ViewBinding
import com.example.blockgeminitasak.data.models.User
import com.example.blockgeminitasak.databinding.ItemUserBinding
import com.example.linkdevworkshop.presentation.ui.base.RecyclerAdapter
import javax.inject.Inject

/**
 * Authored by Abdelrahman Ahmed on 14 Jun, 2021.
 */
class UsersAdapter @Inject constructor() : RecyclerAdapter<User, UsersViewHolder>() {

    private lateinit var onNewsClicked: (User) -> Unit
    override fun instantiateViewHolder(itemView: ViewBinding, viewType: Int) =
        UsersViewHolder(itemView as ItemUserBinding, onNewsClicked)

    override fun generateAsyncDifferCallback(): ItemCallback<User> {
        return object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun generatedBindingLayout(
        inflater: LayoutInflater,
        parent: ViewGroup,
        attachToRoot: Boolean
    ) = ItemUserBinding.inflate(inflater, parent, attachToRoot)

    override fun setItems(items: List<User>) {
        differAsync.submitList(items)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bind(differAsync.currentList[position])
    }

    fun setOnUserClicked(onNewsClicked: (User) -> Unit) {
        this.onNewsClicked = onNewsClicked
    }
}