package dev.ry4nkim.fitpet_homework.presentation.viewmodel.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    private val isLoading = ObservableBoolean()
    private val isRefreshing = ObservableBoolean()

    fun getIsLoading(): ObservableBoolean {
        return isLoading
    }

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }

    fun getIsRefreshing(): ObservableBoolean {
        return isRefreshing
    }

    fun setIsRefreshing(isRefreshing: Boolean) {
        this.isRefreshing.set(isRefreshing)
    }
}