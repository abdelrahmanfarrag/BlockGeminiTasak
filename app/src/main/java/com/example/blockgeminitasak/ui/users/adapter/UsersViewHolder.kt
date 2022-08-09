package com.example.blockgeminitasak.ui.users.adapter

import com.example.blockgeminitasak.data.models.User
import com.example.blockgeminitasak.databinding.ItemUserBinding
import com.example.linkdevworkshop.presentation.ui.base.BaseViewHolder

class UsersViewHolder(
  private val itemNewsBinding: ItemUserBinding,
  private val onUserClicked: (User) -> Unit
) : BaseViewHolder<User>(itemNewsBinding) {
  override fun bind(t: User, isLast: Boolean) {
    itemView.setOnClickListener {
      onUserClicked.invoke(t)
    }
    itemNewsBinding.apply {
      txtName.text =
        String.format("%s %s", t.firstName, t.lastName)
    }
  }
}