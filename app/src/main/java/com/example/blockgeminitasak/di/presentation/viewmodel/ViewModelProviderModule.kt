package com.example.blockgeminitasak.di.presentation.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.example.blockgeminitasak.di.presentation.viewmodel.ViewModelFactoryProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelProviderModule {
  @Binds
  abstract fun bindsViewModelFactory(viewModelFactoryProvider: ViewModelFactoryProvider): ViewModelProvider.Factory
}