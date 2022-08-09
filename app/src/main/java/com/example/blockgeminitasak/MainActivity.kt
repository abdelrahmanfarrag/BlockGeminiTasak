package com.example.blockgeminitasak

import android.view.View
import androidx.navigation.fragment.NavHostFragment
import com.example.blockgeminitasak.databinding.ActivityMainBinding
import com.example.blockgeminitasak.di.presentation.activity.ActivitySubComponent
import com.example.blockgeminitasak.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onActivityInitialized() {
        initNavComponent()
    }

    private fun initNavComponent() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.hostFragmentContainerView) as NavHostFragment
        navHostFragment.navController
    }

    override fun setupInjection(activitySubComponent: ActivitySubComponent) {
    }

    override fun createViewBinding(): View {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }

}