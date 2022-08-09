package com.example.blockgeminitasak.data.validator

import com.example.blockgeminitasak.data.dto.ApiResponse
import com.example.blockgeminitasak.data.models.ErrorResponse
import com.example.blockgeminitasak.data.utility.Error.GENERAL
import com.example.blockgeminitasak.ui.common.Resource
import com.example.blockgeminitasak.ui.common.ResourceState
import com.google.gson.Gson
import retrofit2.Response
import javax.inject.Inject

class Validator @Inject constructor(private val gson: Gson) {

    fun <T> validateApiResponse(response: Response<ApiResponse<T>>?): Resource<ApiResponse<T>> {
        response?.let {
            it.apply {
                if (this.code() in 200..300)
                    if (isSuccessful) {
                        val model = response.body()
                        if (model != null) {
                            modelToJson(model)
                            return Resource(ResourceState.ERROR, data = model)
                        }
                    } else {
                        return Resource(ResourceState.ERROR, message = GENERAL)
                    }
                else
                    handErrorResponse(response)

                }
            }
        return Resource(ResourceState.ERROR, message = GENERAL)
    }

    private fun <T> handErrorResponse(response: Response<T>): Resource<T> {
        val errorResponse =
            gson.fromJson(response.errorBody()?.toString(), ErrorResponse::class.java)
        return Resource(ResourceState.ERROR, message = errorResponse.message ?: GENERAL)
    }

    private fun modelToJson(obj: Any): String {
        return gson.toJson(obj)
    }
}