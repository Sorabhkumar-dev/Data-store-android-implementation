package com.sorabh.datastore.domain.datastore

import kotlinx.coroutines.flow.Flow

interface PreferenceStore {
    suspend fun writeName(name: String)

    suspend fun writeEmail(email: String)

    suspend fun writePhone(phone: String)

    suspend fun writeUserName(userName: String)

    suspend fun writeAddress(address: String)

    suspend fun writePassword(password: String)

    suspend fun writeIsLogin(isLogin: Boolean)

    val readNameFlow: Flow<String>

    val readEmailFlow: Flow<String>

    val readPhoneFlow: Flow<String>

    val raedUserNameFlow: Flow<String>

    val raedAddressFlow: Flow<String>

    val readPasswordFlow: Flow<String>

    val isLoginFlow: Flow<Boolean>
}