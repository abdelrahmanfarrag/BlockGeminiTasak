package com.example.blockgeminitasak.di.presentation.fragment

import com.example.blockgeminitasak.data.repository.UserRepository
import com.example.blockgeminitasak.domain.repository.user.IUserRepository
import com.example.blockgeminitasak.domain.usecase.IUsersUseCase
import com.example.blockgeminitasak.domain.usecase.UsersUseCase
import com.example.blockgeminitasak.di.presentation.scope.PerFragment
import dagger.Binds
import dagger.Module

/**
 * Authored by Abdelrahman Ahmed on 14 Jun, 2021.
 */
@Module
abstract class FragmentModule {


  @Binds
  @PerFragment
  abstract fun bindsUserUseCase(useCase: UsersUseCase): IUsersUseCase
  @Binds
  @PerFragment
  abstract fun bindsUsersRepository(userRepository: UserRepository): IUserRepository
}