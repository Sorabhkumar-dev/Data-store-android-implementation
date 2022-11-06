package com.sorabh.datastore.domain.di

import android.content.Context
import com.sorabh.datastore.domain.datastore.PreferenceStore
import com.sorabh.datastore.domain.datastore.PreferenceStoreImpl
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
}