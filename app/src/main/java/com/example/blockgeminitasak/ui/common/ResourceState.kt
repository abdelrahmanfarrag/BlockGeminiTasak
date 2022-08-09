package com.example.blockgeminitasak.ui.common

import com.example.blockgeminitasak.data.models.ProgressTypes

sealed class ResourceState {
    data class Loading(val progressTypes: ProgressTypes,val shouldShow: Boolean) : ResourceState()
    object SUCCESS : ResourceState()
    object ERROR : ResourceState()
}

