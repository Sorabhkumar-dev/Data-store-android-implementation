package com.sorabh.datastore.domain.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PreferenceStoreImpl @Inject constructor(private val context: Context) : PreferenceStore {
    private val Context.dataStore by preferencesDataStore(name = PreferenceKeys.DATA_STORE)

    override suspend fun writeName(name: String) {
        context.dataStore.edit { preference ->
            preference[PreferenceKeys.name] = name
        }
    }

    override suspend fun writeEmail(email: String) {
        context.dataStore.edit { preference ->
            preference[PreferenceKeys.email] = email
        }
    }

    override suspend fun writePhone(phone: String) {
        context.dataStore.edit { preference ->
            preference[PreferenceKeys.phone] = phone
        }
    }

    override suspend fun writeUserName(userName: String) {
        context.dataStore.edit { preference ->
            preference[PreferenceKeys.username] = userName
        }
    }

    override suspend fun writeAddress(address: String) {
        context.dataStore.edit { preference ->
            preference[PreferenceKeys.address] = address
        }
    }

    override suspend fun writePassword(password: String) {
        context.dataStore.edit { preference ->
            preference[PreferenceKeys.password] = password
        }
    }

    override suspend fun writeIsLogin(isLogin: Boolean) {
        context.dataStore.edit { preference ->
            preference[PreferenceKeys.isLogin] = isLogin
        }
    }

    override val readNameFlow = context.dataStore.data
        .catch {
            if (this is Exception)
                emit(emptyPreferences())
        }.map { preference ->
            val name = preference[PreferenceKeys.name] ?: ""
            name
        }

    override val readEmailFlow = context.dataStore.data
        .catch { if (this is Exception) emit(emptyPreferences()) }.map { preference ->
            val email = preference[PreferenceKeys.email] ?: ""
            email
        }

    override val readPhoneFlow =
        context.dataStore.data.catch { if (this is Exception) emit(emptyPreferences()) }
            .map { preference ->
                val phone = preference[PreferenceKeys.phone] ?: ""
                phone
            }

    override val raedUserNameFlow = context.dataStore.data.catch {
        if (this is Exception) emit(
            emptyPreferences()
        )
    }.map { preference ->
        val userName = preference[PreferenceKeys.username] ?: ""
        userName
    }

    override val raedAddressFlow =
        context.dataStore.data.catch { if (this is Exception) emit(emptyPreferences()) }
            .map { preference ->
                val address = preference[PreferenceKeys.address] ?: ""
                address
            }

    override val readPasswordFlow =
        context.dataStore.data.catch { if (this is Exception) emit(emptyPreferences()) }
            .map { preference ->
                val password = preference[PreferenceKeys.password] ?: ""
                password
            }
    override val isLoginFlow =
        context.dataStore.data.catch { if (this is Exception) emit(emptyPreferences()) }
            .map { preference ->
                val isLogin = preference[PreferenceKeys.isLogin] ?: false
                isLogin
            }
}