package com.example.blockgeminitasak.domain.repository.user

import com.example.blockgeminitasak.data.models.User
import com.example.blockgeminitasak.data.models.UsersResponse
import com.example.blockgeminitasak.ui.common.Resource
import io.reactivex.Single

interface IUserRepository {

    fun loadUsers(page: Int): Single<Resource<UsersResponse>>
}