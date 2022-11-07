package com.sorabh.datastore.domain.model

data class Payment(
    val receiverName: String,
    val amount: Int,
    val accountNo: String,
    val bankName: String,
    val message: String?
)
