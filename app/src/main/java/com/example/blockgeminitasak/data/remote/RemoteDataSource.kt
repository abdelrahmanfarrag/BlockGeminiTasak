package com.example.blockgeminitasak.data.remote

import com.example.blockgeminitasak.data.api.Api
import com.example.blockgeminitasak.data.dto.ApiResponse
import com.example.blockgeminitasak.data.models.User
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val api: Api) : IRemoteDataSource {

    override fun getUsers(currentPage: Int): Single<Response<ApiResponse<ArrayList<User>>>> {
        return api.loadUsers(currentPage)
    }


}