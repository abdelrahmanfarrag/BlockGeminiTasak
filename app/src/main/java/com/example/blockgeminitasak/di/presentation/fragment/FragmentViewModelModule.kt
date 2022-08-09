package com.example.blockgeminitasak.di.presentation.fragment

import androidx.lifecycle.ViewModel
import com.example.blockgeminitasak.di.presentation.binding.ViewModelKey
import com.example.blockgeminitasak.di.presentation.viewmodel.ViewModelProviderModule
import com.example.blockgeminitasak.ui.users.UsersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Authored by Abdelrahman Ahmed on 14 Jun, 2021.
 * Contact: afarrag@youxel.com
 * by :YOUXEL
 */
@Module(includes = [ViewModelProviderModule::class])
abstract class FragmentViewModelModule {

  @Binds
  @IntoMap
  @ViewModelKey(UsersViewModel::class)
  abstract fun bindsUsersViewModel(newsViewModel: UsersViewModel): ViewModel

}