package com.ashamsi.domain.exception

/**
 * [Throwable] thrown when a domain entity fails to parse.
 */
class EntityException: Throwable{
    constructor(message: String?): super(message, null)
    constructor(cause: Throwable): super(cause.toString(), cause)
}