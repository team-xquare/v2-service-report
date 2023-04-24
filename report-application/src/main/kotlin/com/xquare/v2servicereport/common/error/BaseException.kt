package com.xquare.v2servicereport.common.error

abstract class BaseException(
    val errorProperty: ErrorProperty
) : RuntimeException() {

    override fun fillInStackTrace() = this
}
