package com.example.blockgeminitasak.di.presentation.fragment

import androidx.fragment.app.Fragment
import com.example.blockgeminitasak.di.presentation.scope.PerFragment
import com.example.blockgeminitasak.ui.users.UsersFragment
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * Authored by Abdelrahman Ahmed on 14 Jun, 2021.
 * Contact: afarrag@youxel.com
 * by :YOUXEL
 */
@PerFragment
@Subcomponent(modules = [FragmentViewModelModule::class, FragmentModule::class])
interface FragmentSubComponent {

  fun inject(usersFragment: UsersFragment)

  @Subcomponent.Factory
  interface Factory {
    fun create(@BindsInstance fragment: Fragment): FragmentSubComponent

  }
}