package com.sorabh.datastore.domain.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferenceKeys {
    val name = stringPreferencesKey("name")
    val email = stringPreferencesKey("email")
    val phone = stringPreferencesKey("phone")
    val username = stringPreferencesKey("user_name")
    val address = stringPreferencesKey("address")
    val password = stringPreferencesKey("password")
    val isLogin = booleanPreferencesKey("isLogin")
    const val DATA_STORE = "datastore"
}