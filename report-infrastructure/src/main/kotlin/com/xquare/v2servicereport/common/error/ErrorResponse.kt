package com.xquare.v2servicereport.common.error

import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError

data class ErrorResponse(
    val status: Int,
    val message: String,
)

data class ValidationErrorResponse(
    val status: Int,
    val fieldError: Map<String, String?>,
)

fun BindingResult.of(): ValidationErrorResponse {
    val errorMap = HashMap<String, String?>()

    for (error: FieldError in this.fieldErrors) {
        errorMap[error.field] = error.defaultMessage
    }

    return ValidationErrorResponse(
        status = GlobalErrorCode.BAD_REQUEST.status(),
        fieldError = errorMap
    )
}

fun ErrorProperty.of(): ErrorResponse {
    return ErrorResponse(
        status = this.status(),
        message = this.message(),
    )
}
