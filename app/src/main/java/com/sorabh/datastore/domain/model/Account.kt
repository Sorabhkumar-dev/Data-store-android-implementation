package com.sorabh.datastore.domain.model

data class Account(
    val bankName:String,
    val accountNo: Int,
    val accountHolder: String,
    val phoneNo:Int,
    val emailId:String,
    val ifscCode: String,
    val branchName: String,
    val balance: Int
)