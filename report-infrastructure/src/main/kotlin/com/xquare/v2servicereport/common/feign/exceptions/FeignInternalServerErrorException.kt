package com.xquare.v2servicereport.common.feign.exceptions

import com.xquare.v2servicereport.common.error.BaseException
import com.xquare.v2servicereport.common.feign.error.FeignErrorCode

object FeignInternalServerErrorException : BaseException(
    FeignErrorCode.FEIGN_INTERNAL_SERVER_ERROR,
)
