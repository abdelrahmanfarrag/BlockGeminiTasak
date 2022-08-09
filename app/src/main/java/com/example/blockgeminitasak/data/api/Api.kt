package com.example.blockgeminitasak.data.api

import com.example.blockgeminitasak.data.api.EndPoints.Query.PAGE
import com.example.blockgeminitasak.data.api.EndPoints.USERS
import com.example.blockgeminitasak.data.dto.ApiResponse
import com.example.blockgeminitasak.data.models.User
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET(USERS)
    fun loadUsers(@Query(PAGE) page: Int): Single<Response<ApiResponse<ArrayList<User>>>>
}