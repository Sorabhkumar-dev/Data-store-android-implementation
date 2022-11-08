package com.sorabh.datastore.domain.di

import android.content.Context
import androidx.datastore.core.Serializer
import com.sorabh.datastore.domain.datastore.AccountDataStore
import com.sorabh.datastore.domain.datastore.AccountDataStoreImpl
import com.sorabh.datastore.domain.datastore.PreferenceStore
import com.sorabh.datastore.domain.datastore.PreferenceStoreImpl
import com.sorabh.datastore.domain.proto_datastore.AccountSerializer
import com.sorabh.datastore.proto.Account
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataStoreModule {

    @Provides
    @Singleton
    fun providePreferenceStore(preferenceStoreImpl: PreferenceStoreImpl): PreferenceStore =
        preferenceStoreImpl

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context = context

    @Provides
    @Singleton
    fun provideAccountSerializer(): Serializer<Account> = AccountSerializer

    @Provides
    @Singleton
    fun provideAccountDataStore(accountDataStoreImpl: AccountDataStoreImpl): AccountDataStore =
        accountDataStoreImpl
}