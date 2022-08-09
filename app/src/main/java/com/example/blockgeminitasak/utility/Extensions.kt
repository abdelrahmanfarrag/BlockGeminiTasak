package com.example.blockgeminitasak.utility

import androidx.lifecycle.MutableLiveData
import com.example.blockgeminitasak.data.models.ProgressTypes
import com.example.blockgeminitasak.ui.common.Resource
import com.example.blockgeminitasak.ui.common.ResourceState

fun <T> MutableLiveData<Resource<T>>.setSuccess(
    data: T
) = postValue(Resource(ResourceState.SUCCESS, data))

fun <T> MutableLiveData<Resource<T>>.setLoading(progressType: ProgressTypes) =
    postValue(Resource(ResourceState.Loading(progressType, true), value?.data))

fun <T> MutableLiveData<Resource<T>>.setError(
    message: String
) = postValue(Resource(ResourceState.ERROR, value?.data, message))
