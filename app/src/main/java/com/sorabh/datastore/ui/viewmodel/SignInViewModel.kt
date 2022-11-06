package com.sorabh.datastore.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.sorabh.datastore.domain.datastore.PreferenceStore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val preferenceStore: PreferenceStore) :
    ViewModel() {
    val phoneFlow = preferenceStore.readPhoneFlow
    val emailFlow = preferenceStore.readEmailFlow
    val passwordFlow = preferenceStore.readPasswordFlow

}