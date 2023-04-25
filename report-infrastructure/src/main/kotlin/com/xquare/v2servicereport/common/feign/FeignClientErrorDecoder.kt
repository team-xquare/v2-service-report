package com.xquare.v2servicereport.common.feign

import com.xquare.v2servicereport.common.feign.exceptions.FeignBadRequestException
import com.xquare.v2servicereport.common.feign.exceptions.FeignExpiredTokenException
import com.xquare.v2servicereport.common.feign.exceptions.FeignForbiddenException
import com.xquare.v2servicereport.common.feign.exceptions.FeignInternalServerErrorException
import com.xquare.v2servicereport.common.feign.exceptions.FeignUnAuthorizedException
import feign.FeignException
import feign.Response
import feign.codec.ErrorDecoder

class FeignClientErrorDecoder : ErrorDecoder {

    override fun decode(methodKey: String, response: Response): Exception {
        if (response.status() >= 400) {
            when (response.status()) {
                400 -> throw FeignBadRequestException
                401 -> throw FeignUnAuthorizedException
                403 -> throw FeignForbiddenException
                419 -> throw FeignExpiredTokenException
                else -> throw FeignInternalServerErrorException
            }
        }
        return FeignException.errorStatus(methodKey, response)
    }
}
