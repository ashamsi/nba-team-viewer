package com.ashamsi.domain

/**
 * Contract for log services.
 */
interface LogUtils {
    /**
     * Send info related log message and log the exception if provided.
     */
    fun i(tag: String, message: String, throwable: Throwable? = null)

    /**
     * Send debug related log message and log the exception if provided.
     */
    fun d(tag: String, message: String, throwable: Throwable? = null)

    /**
     * Send warning related log message and log the exception if provided.
     */
    fun w(tag: String, message: String, throwable: Throwable? = null)

    /**
     * Send error related log message and log the exception if provided.
     */
    fun e(tag: String, message: String, throwable: Throwable? = null)
}