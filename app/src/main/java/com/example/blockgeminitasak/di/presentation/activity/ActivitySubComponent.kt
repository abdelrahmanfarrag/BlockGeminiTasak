package com.example.blockgeminitasak.di.presentation.activity

import android.app.Activity
import com.example.blockgeminitasak.di.presentation.scope.PerActivity
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * Authored by Abdelrahman Ahmed on 15 Jun, 2021.
 */
@PerActivity
@Subcomponent(modules = [ActivityModule::class, ActivityViewModelModule::class])
interface ActivitySubComponent {


  @Subcomponent.Factory
  interface Factory {
    fun create(@BindsInstance activity: Activity): ActivitySubComponent
  }
}