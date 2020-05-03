package com.ashamsi.domain.util

import com.ashamsi.domain.LogUtils

object SystemLogUtils : LogUtils {
    override fun i(tag: String, message: String, throwable: Throwable?) {
        if (throwable == null) println("I/$tag : $message") else println("""I/$tag : $message
            |${throwable.message}""".trimMargin())
    }

    override fun d(tag: String, message: String, throwable: Throwable?) {
        if (throwable == null) println("D/$tag : $message") else println("""D/$tag : $message
            |${throwable.message}""".trimMargin())
    }

    override fun w(tag: String, message: String, throwable: Throwable?) {
        if (throwable == null) println("W/$tag : $message") else println("""W/$tag : $message
            |${throwable.message}""".trimMargin())
    }

    override fun e(tag: String, message: String, throwable: Throwable?) {
        if (throwable == null) println("E/$tag : $message") else println("""E/$tag : $message
            |${throwable.message}""".trimMargin())
    }
}