package com.sorabh.datastore.domain.proto_datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException
import com.sorabh.datastore.proto.Account
import java.io.InputStream
import java.io.OutputStream

object AccountSerializer :Serializer<Account> {
    override val defaultValue: Account
        get() = Account.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): Account {
        try{
            return Account.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: Account, output: OutputStream)  = t.writeTo(output)
}