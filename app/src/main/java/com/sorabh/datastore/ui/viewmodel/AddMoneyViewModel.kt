package com.sorabh.datastore.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.sorabh.datastore.domain.datastore.AccountDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddMoneyViewModel @Inject constructor(private val accountDataStore: AccountDataStore) :
    ViewModel() {
    suspend fun updateAccountData(
        bankName: String,
        accountHolder: String,
        accountNo: Long,
        phoneNo: Long,
        emailId: String,
        ifscCode: String,
        branchName: String,
        accountBalance: Long
    ) {
        accountDataStore.writeAccountData(
            bankName,
            accountNo,
            accountHolder,
            phoneNo,
            emailId,
            ifscCode,
            branchName,
            accountBalance
        )
    }

}