package com.example.blockgeminitasak.data.remote

import com.example.blockgeminitasak.data.dto.ApiResponse
import com.example.blockgeminitasak.data.models.User
import com.example.blockgeminitasak.data.models.UsersResponse
import io.reactivex.Single
import retrofit2.Response

interface IRemoteDataSource {

    fun getUsers(currentPage: Int): Single<Response<ApiResponse<ArrayList<User>>>>
}