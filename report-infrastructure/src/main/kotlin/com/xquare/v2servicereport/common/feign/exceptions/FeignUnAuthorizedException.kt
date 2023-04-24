package com.xquare.v2servicereport.common.feign.exceptions

import com.xquare.v2servicereport.common.error.BaseException
import com.xquare.v2servicereport.common.feign.error.FeignErrorCode

object FeignUnAuthorizedException : BaseException(
    FeignErrorCode.FEIGN_UNAUTHORIZED,
)
