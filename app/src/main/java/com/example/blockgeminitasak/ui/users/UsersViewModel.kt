package com.example.blockgeminitasak.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.blockgeminitasak.data.models.ProgressTypes
import com.example.blockgeminitasak.data.models.UsersResponse
import com.example.blockgeminitasak.domain.usecase.IUsersUseCase
import com.example.blockgeminitasak.ui.common.Resource
import com.example.blockgeminitasak.utility.Error.GENERAL
import com.example.blockgeminitasak.utility.setError
import com.example.blockgeminitasak.utility.setLoading
import com.example.blockgeminitasak.utility.setSuccess
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UsersViewModel @Inject constructor(private val iUsersUseCase: IUsersUseCase) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val _users = MutableLiveData<Resource<UsersResponse>>()

    var currentPage = 1
    var totalPages = -1
    val users: LiveData<Resource<UsersResponse>>
        get() = _users

    fun getUsers(swipeRefresh: Boolean = false) {
        if (swipeRefresh)
            currentPage = 1
            if (currentPage <= totalPages || currentPage == 1) {
                compositeDisposable.add(iUsersUseCase.loadUsers(currentPage)
                    .doOnSubscribe {
                        if (currentPage == 1)
                            _users.setLoading(ProgressTypes.MAIN_PROGRESS)
                        else {
                            if (swipeRefresh)
                                _users.setLoading(ProgressTypes.MAIN_PROGRESS)
                            else
                                _users.setLoading(ProgressTypes.PAGING_PROGRESS)
                        }
                    }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ usersResponse ->
                        usersResponse.data?.let {
                            if (totalPages < (it.totalPages ?: 0)) {
                                totalPages = it.totalPages ?: 0
                                currentPage++
                            }
                            _users.setSuccess(it)
                        } ?: _users.setError(usersResponse?.message ?: GENERAL)
                    }, { _ ->
                        _users.setError(GENERAL)
                    })
                )
            }else {
                _users.setError(GENERAL)
            }
    }

    override fun onCleared() {
        compositeDisposable.dispose()
    }
}