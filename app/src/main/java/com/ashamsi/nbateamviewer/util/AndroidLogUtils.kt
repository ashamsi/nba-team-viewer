package com.ashamsi.nbateamviewer.util

import android.util.Log
import com.ashamsi.domain.LogUtils

class AndroidLogUtils : LogUtils {

    override fun i(tag: String, message: String, throwable: Throwable?) {
        if (throwable == null) Log.i(validTag(tag), validMessage(message)) else Log.i(validTag(tag), validMessage(message), throwable)
    }

    override fun d(tag: String, message: String, throwable: Throwable?) {
        if (throwable == null) Log.d(validTag(tag), validMessage(message)) else Log.i(validTag(tag), validMessage(message), throwable)
    }

    override fun w(tag: String, message: String, throwable: Throwable?) {
        if (throwable == null) Log.w(validTag(tag), validMessage(message)) else Log.i(validTag(tag), validMessage(message), throwable)
    }

    override fun e(tag: String, message: String, throwable: Throwable?) {
        if (throwable == null) Log.e(validTag(tag), validMessage(message)) else Log.i(validTag(tag), validMessage(message), throwable)
    }

    /**
     * Returns the [String] representation of the provided [tag] that is validated against its length to be no longer than 22 chars.
     */
    private fun validTag(tag: String): String {
        return if (tag.length <= 22) tag else tag.substring(0..22)
    }

    /**
     * Returns the [String] representation of the provided [message] if it is not null or empty [String].
     */
    private fun validMessage(message: String?): String {
        return message ?: ""
    }
}