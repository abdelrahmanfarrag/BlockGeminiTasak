package com.example.blockgeminitasak.data.repository

import com.example.blockgeminitasak.data.models.User
import com.example.blockgeminitasak.data.models.UsersResponse
import com.example.blockgeminitasak.data.remote.IRemoteDataSource
import com.example.blockgeminitasak.data.validator.Validator
import com.example.blockgeminitasak.domain.repository.user.IUserRepository
import com.example.blockgeminitasak.ui.common.Resource
import com.example.blockgeminitasak.ui.common.ResourceState
import io.reactivex.Single
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val mIRemoteDataSource: IRemoteDataSource,
    private val mValidator: Validator
) : IUserRepository {

    override fun loadUsers(page: Int): Single<Resource<UsersResponse>> {
        return mIRemoteDataSource.getUsers(page).map {
            mValidator.validateApiResponse(it)
        }.map { users ->
            users.data?.let { usersResponse ->
                Resource(
                    ResourceState.SUCCESS,
                    data = UsersResponse(
                        usersResponse.total,
                        usersResponse.page,
                        usersResponse.data
                    )
                )
            } ?: Resource(ResourceState.ERROR, message = users.message)
        }
    }

}