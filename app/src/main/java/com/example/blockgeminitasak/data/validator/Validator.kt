package com.example.blockgeminitasak.data.validator

import com.example.blockgeminitasak.data.dto.ApiResponse
import com.example.blockgeminitasak.data.internet.IInternetInterceptor
import com.example.blockgeminitasak.data.models.ErrorResponse
import com.example.blockgeminitasak.ui.common.Resource
import com.example.blockgeminitasak.ui.common.ResourceState
import com.example.blockgeminitasak.utility.Error.GENERAL
import com.example.blockgeminitasak.utility.Error.NETWORK
import com.google.gson.Gson
import retrofit2.Response
import javax.inject.Inject

class Validator @Inject constructor(
    private val gson: Gson,
    private val iInternetInterceptor: IInternetInterceptor
) {

    fun <T> validateApiResponse(response: Response<ApiResponse<T>>?): Resource<ApiResponse<T>> {
        response?.let {
            it.apply {
                if (iInternetInterceptor.isConnected) {
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
                } else
                    return Resource(ResourceState.ERROR, message = NETWORK)
            }
        }
        val message = if (iInternetInterceptor.isConnected) GENERAL else NETWORK
        return Resource(ResourceState.ERROR, message = message)
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