package com.example.blockgeminitasak.ui.common

import com.example.blockgeminitasak.utility.Error.GENERAL

class Resource<out T> constructor(
  val state: ResourceState,
  val data: T? = null,
  val message: String = GENERAL
)