package com.sorabh.datastore.domain.datastore

import com.sorabh.datastore.proto.Account
import kotlinx.coroutines.flow.Flow

interface AccountDataStore {
   suspend fun writeAccountData(
        bankName: String,
        accountNo: Long,
        accountHolder: String,
        phoneNo: Long,
        emailId: String,
        ifscCode: String,
        branchName: String,
        accountBalance: Long
    )

    val readAccountFlow : Flow<Account>
}