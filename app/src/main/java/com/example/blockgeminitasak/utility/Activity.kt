package com.example.blockgeminitasak.utility

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.blockgeminitasak.ui.base.BaseActivity
import com.example.blockgeminitasak.ui.common.Resource
import com.example.blockgeminitasak.ui.common.ResourceState

fun BaseActivity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun <T : ViewModel> BaseActivity.getViewModel(
    modelClass: Class<T>,
    viewModelFactory: ViewModelProvider.Factory? = null
): T {
    return viewModelFactory?.let { factory ->
        ViewModelProvider(this as ViewModelStoreOwner, factory).get(modelClass)
    } ?: ViewModelProvider(this as ViewModelStoreOwner).get(modelClass)
}



