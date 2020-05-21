package com.sample.phonebook.common.ui

import android.content.Context
import java.io.File


class FileCache(var context: Context) {
    private var cacheDir: File? = null

    init {
        //Find the dir to save cached images
        if (android.os.Environment.getExternalStorageState() == android.os.Environment.MEDIA_MOUNTED)
            cacheDir = File(android.os.Environment.getExternalStorageDirectory(), "TempImages")
        else
            cacheDir = context.getCacheDir()
        if (!cacheDir!!.exists())
            cacheDir!!.mkdirs()
    }

    fun getFile(url: String): File {
        val filename = url.hashCode().toString()
        return File(cacheDir, filename)

    }

    fun clear() {
        val files = cacheDir!!.listFiles() ?: return
        for (f in files)
            f.delete()
    }

}