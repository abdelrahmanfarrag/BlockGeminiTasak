package com.example.blockgeminitasak.data.internet

import android.app.Application
import com.example.blockgeminitasak.utility.checkInternetConnection
import javax.inject.Inject

class InternetInterceptor @Inject constructor(private val application: Application) :
    IInternetInterceptor {

    override val isConnected: Boolean
        get() = application.checkInternetConnection()

}