package com.sorabh.datastore.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.sorabh.datastore.domain.datastore.AccountDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(private val dataStore: AccountDataStore):ViewModel() {
    fun getAccountDetail() = dataStore.readAccountFlow
}