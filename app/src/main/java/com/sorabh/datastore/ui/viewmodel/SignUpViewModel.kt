package com.sorabh.datastore.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.sorabh.datastore.domain.datastore.PreferenceStore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val preferenceStore: PreferenceStore) :
    ViewModel() {

    suspend fun writeName(name: String) {
        preferenceStore.writeName(name)
    }

    suspend fun writeEmail(email: String) {
        preferenceStore.writeEmail(email)
    }

    suspend fun writePhone(phone: String) {
        preferenceStore.writePhone(phone)
    }

    suspend fun writeUserName(userName: String) {
        preferenceStore.writeUserName(userName)
    }

    suspend fun writeAddress(address: String) {
        preferenceStore.writeAddress(address)
    }

    suspend fun writePassword(password: String) {
        preferenceStore.writePassword(password)
    }

    suspend fun writeIsLogin(isLogin: Boolean) {
        preferenceStore.writeIsLogin(isLogin)
    }
}