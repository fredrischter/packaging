package com.logistics.packaging.exception

open class APIException: Exception {

    constructor(): super() {
    }

    constructor(e: Exception): super(e) {
    }
}