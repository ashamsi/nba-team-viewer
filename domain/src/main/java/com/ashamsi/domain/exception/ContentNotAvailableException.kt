package com.ashamsi.domain.exception

class ContentNotAvailableException: Throwable {
    constructor(message: String?): super("Content Not Available", null)
    constructor(cause: Throwable): super(cause.toString(), cause)
}