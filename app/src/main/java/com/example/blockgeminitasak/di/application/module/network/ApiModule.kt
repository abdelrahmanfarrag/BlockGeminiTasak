package com.example.blockgeminitasak.di.application.module.network

import com.example.blockgeminitasak.data.api.Api
import com.example.blockgeminitasak.di.application.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
abstract class ApiModule {
  companion object {
    @Provides
    @ApplicationScope
    fun providesApi(
      retrofit: Retrofit
    ): Api = retrofit.create(Api::class.java)
  }
}