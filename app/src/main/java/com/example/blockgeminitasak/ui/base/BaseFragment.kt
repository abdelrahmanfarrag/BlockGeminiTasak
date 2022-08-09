package com.example.blockgeminitasak.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.blockgeminitasak.BlockGeminiApp
import com.example.blockgeminitasak.di.presentation.fragment.FragmentSubComponent
import com.example.blockgeminitasak.utility.adjustViewPan

/**
 * Authored by Abdelrahman Ahmed on 14 Jun, 2021.
 */
abstract class BaseFragment : Fragment() {

  /**
   * @SubComponentEntry
   */

  private val fragmentSubComponent: FragmentSubComponent by lazy {
    BlockGeminiApp.get(requireActivity()).appComponent.getFragmentSubComponent().create(this)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    setupInjection(fragmentSubComponent)
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ) = createViewBinding(inflater, container, savedInstanceState)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    adjustViewPan()
    onFragmentSetup(view, savedInstanceState)
    setupToolbar()
  }

  override fun onDestroyView() {
    releaseObjects()
    super.onDestroyView()
  }

  /**
   * Here is this function we will call any setup for views in Sub-Fragment
   * Such as calling webservices ,observing web services response , and any additional actions on view we will but in this function
   * which will be overrode by any Sub-Fragment
   */
  abstract fun onFragmentSetup(view: View, savedInstanceState: Bundle?)

  /**
   * This function will be overrode by any Child-Fragment to do member field injection in each fragment
   */
  abstract fun setupInjection(fragmentSubComponent: FragmentSubComponent)

  abstract fun createViewBinding(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View

  /**
   * This function is optional to override in any Child-Fragment as may a fragment has no toolbar
   */
  open fun setupToolbar() {}

  /**
   * To release some @objects or reset some @Functionality when fragment get Destroyed
   */
  open fun releaseObjects() {}

}