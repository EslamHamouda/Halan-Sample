package com.android.consumerfinancehalan.common.mapper

interface Mapper<F,T> {
    fun mapTo(from: F): T
}