package com.ashamsi.nbateamviewer.util

import android.content.Context
import java.io.File

class StorageUtils {
    companion object {
        fun getCacheDir(context: Context): File {
            return context.cacheDir
        }
    }
}