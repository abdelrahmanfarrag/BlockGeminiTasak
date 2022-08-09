package com.example.blockgeminitasak.di.application.module

import com.example.blockgeminitasak.data.remote.IRemoteDataSource
import com.example.blockgeminitasak.data.remote.RemoteDataSource
import com.example.blockgeminitasak.di.application.scope.ApplicationScope
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    @ApplicationScope
    abstract fun bindsRemoteDataSource(remoteDataSource: RemoteDataSource): IRemoteDataSource
}