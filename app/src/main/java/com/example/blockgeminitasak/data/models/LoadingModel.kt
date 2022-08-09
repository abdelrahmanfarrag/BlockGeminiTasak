package com.example.blockgeminitasak.data.models

import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

data class LoadingModel(
    val shouldShow: Boolean,
    val progressType: ProgressTypes,
    var loadingFullProgressView: RelativeLayout? = null,
    var loadingProgressView: ProgressBar? = null,
    var pagingProgressView: ProgressBar? = null,
    var pullToRefreshProgressView: SwipeRefreshLayout? = null,
)
