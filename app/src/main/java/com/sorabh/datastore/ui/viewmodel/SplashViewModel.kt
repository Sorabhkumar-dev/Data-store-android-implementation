package com.sorabh.datastore.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.sorabh.datastore.domain.datastore.PreferenceStore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val preferenceStore: PreferenceStore):ViewModel() {
    val isLoginFlow = preferenceStore.isLoginFlow
}