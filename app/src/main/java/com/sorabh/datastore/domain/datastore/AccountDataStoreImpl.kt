package com.sorabh.datastore.domain.datastore

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.sorabh.datastore.domain.utils.Constant
import com.sorabh.datastore.proto.Account
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import java.io.IOException
import javax.inject.Inject

class AccountDataStoreImpl @Inject constructor(
    private val context: Context,
    serializer: Serializer<Account>
) : AccountDataStore {

    private val Context.accountData: DataStore<Account> by dataStore(
        fileName = Constant.DATA_STORE_FILE_NAME,
        serializer = serializer
    )

    override suspend fun writeAccountData(
        bankName: String,
        accountNo: Long,
        accountHolder: String,
        phoneNo: Long,
        emailId: String,
        ifscCode: String,
        branchName: String,
        accountBalance: Long
    ) {
        context.accountData.updateData { preference ->
            preference.toBuilder()
                .setBankName(bankName)
                .setAccountNo(accountNo)
                .setAccountHolder(accountHolder)
                .setPhoneNo(phoneNo)
                .setEmailId(emailId)
                .setIfscCode(ifscCode)
                .setBranchName(branchName)
                .setAccountBalance(accountBalance)
                .build()
        }
    }

    override val readAccountFlow: Flow<Account>
        get() = context.accountData.data.catch { exception ->
            if (exception is IOException) {
                Log.e(Constant.TAG, "Error reading sort order preferences.", exception)
                emit(Account.getDefaultInstance())
            } else {
                throw exception
            }
        }
}
