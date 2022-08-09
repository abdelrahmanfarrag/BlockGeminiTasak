package com.example.blockgeminitasak.domain.usecase

import com.example.blockgeminitasak.data.models.User
import com.example.blockgeminitasak.data.models.UsersResponse
import com.example.blockgeminitasak.ui.common.Resource
import io.reactivex.Single

interface IUsersUseCase {

    fun loadUsers(page: Int): Single<Resource<UsersResponse>>
}