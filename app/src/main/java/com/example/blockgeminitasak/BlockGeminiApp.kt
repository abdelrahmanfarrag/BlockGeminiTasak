package com.example.blockgeminitasak

import android.app.Application
import androidx.fragment.app.FragmentActivity
import com.example.blockgeminitasak.di.application.component.AppComponent
import com.example.blockgeminitasak.di.application.component.DaggerAppComponent

class BlockGeminiApp : Application() {

    lateinit var appComponent: AppComponent

    companion object {
        fun get(activity: FragmentActivity): BlockGeminiApp {
            return activity.application as BlockGeminiApp
        }
    }

    override fun onCreate() {
        super.onCreate()
        setupInjection()
    }

    private fun setupInjection() {
        appComponent = DaggerAppComponent.factory().create(this)
    }
}