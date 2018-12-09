package com.logistics.packaging.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class WrongParametersException: APIException {

    constructor(): super() {
    }

    constructor(e: Exception): super(e) {
    }
}