package com.example.blockgeminitasak.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.blockgeminitasak.R
import com.example.blockgeminitasak.data.models.ProgressTypes
import com.example.blockgeminitasak.databinding.FragmentUsersBinding
import com.example.blockgeminitasak.di.presentation.fragment.FragmentSubComponent
import com.example.blockgeminitasak.di.presentation.viewmodel.ViewModelFactoryProvider
import com.example.blockgeminitasak.ui.base.BaseFragment
import com.example.blockgeminitasak.ui.users.adapter.UsersAdapter
import com.example.blockgeminitasak.utility.Error.GENERAL
import com.example.blockgeminitasak.utility.Error.NETWORK
import com.example.blockgeminitasak.utility.PagingScrollListener
import com.example.blockgeminitasak.utility.getViewModel
import com.example.blockgeminitasak.utility.observingLiveDataOfFragment
import com.example.blockgeminitasak.utility.toast
import javax.inject.Inject

class UsersFragment : BaseFragment(), PagingScrollListener.PagingScrollListenerInteractions {

    @Inject
    lateinit var factoryProvider: ViewModelFactoryProvider

    @Inject
    lateinit var usersAdapter: UsersAdapter
    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!
    private val userViewModel by lazy {
        getViewModel(UsersViewModel::class.java, factoryProvider)
    }

    override fun createViewBinding(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onFragmentSetup(view: View, savedInstanceState: Bundle?) {
        setSwipeRefresh()
        userViewModel.getUsers(false)
        observingLiveDataOfFragment(userViewModel.users, { users ->
            usersAdapter.setOnUserClicked { user ->
                toast(user.email ?: "")
            }
            _binding?.usersRecyclerView?.adapter = usersAdapter
            usersAdapter.setItems(users?.users ?: mutableListOf())
        }, {
            when (it) {
                GENERAL -> toast(getString(R.string.un_expected_error))
                NETWORK -> toast(getString(R.string.internet_connection_error))
                else -> toast(getString(R.string.un_expected_error))
            }
        }, { _: ProgressTypes?, isRefresh: Boolean ->
            binding.progressbar.visibility = if (binding.swipeRefresh.isRefreshing) {
                if (isRefresh) View.VISIBLE else View.GONE
            } else
                View.GONE
            binding.swipeRefresh.isRefreshing = false

        })
    }

    override fun setupInjection(fragmentSubComponent: FragmentSubComponent) {
        fragmentSubComponent.inject(this)
    }

    override fun releaseObjects() {
        _binding = null
    }

    override fun onScroll() {
        userViewModel.getUsers(false)
    }

    private fun setSwipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            userViewModel.getUsers(true)
        }
    }
}