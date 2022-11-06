package com.sorabh.datastore.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.sorabh.datastore.domain.datastore.PreferenceStore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val preferenceStore: PreferenceStore):ViewModel() {
    val nameFlow = preferenceStore.readNameFlow
    val emailFlow = preferenceStore.readEmailFlow
    val userIdFlow = preferenceStore.raedUserNameFlow
    val addressFlow = preferenceStore.raedAddressFlow
}