package com.xquare.v2servicereport.common.feign.exceptions

import com.xquare.v2servicereport.common.error.BaseException
import com.xquare.v2servicereport.common.feign.error.FeignErrorCode

object FeignExpiredTokenException : BaseException(
    FeignErrorCode.FEIGN_EXPIRED_TOKEN,
)
