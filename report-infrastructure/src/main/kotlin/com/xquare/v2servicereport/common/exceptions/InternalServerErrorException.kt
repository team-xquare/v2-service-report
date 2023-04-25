package com.xquare.v2servicereport.common.exceptions

import com.xquare.v2servicereport.common.error.GlobalErrorCode
import com.xquare.v2servicereport.common.error.BaseException

object InternalServerErrorException : BaseException(
    GlobalErrorCode.INTERNAL_SERVER_ERROR,
)
