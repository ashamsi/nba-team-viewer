package com.ashamsi.domain.util

import com.ashamsi.domain.LogUtils


class EmptyLogUtils : LogUtils {
    override fun i(tag: String, message: String, throwable: Throwable?) {
        // no-op
    }

    override fun d(tag: String, message: String, throwable: Throwable?) {
        // no-op
    }

    override fun w(tag: String, message: String, throwable: Throwable?) {
        // no-op
    }

    override fun e(tag: String, message: String, throwable: Throwable?) {
        // no-op
    }
}
