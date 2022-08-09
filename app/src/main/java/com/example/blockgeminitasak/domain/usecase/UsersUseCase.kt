package com.example.blockgeminitasak.domain.usecase

import com.example.blockgeminitasak.data.models.User
import com.example.blockgeminitasak.data.models.UsersResponse
import com.example.blockgeminitasak.domain.repository.user.IUserRepository
import com.example.blockgeminitasak.ui.common.Resource
import io.reactivex.Single
import javax.inject.Inject

class UsersUseCase @Inject constructor(private val iUserRepository: IUserRepository) : IUsersUseCase {

    override fun loadUsers(page: Int): Single<Resource<UsersResponse>> {
        return iUserRepository.loadUsers(page)
    }
}