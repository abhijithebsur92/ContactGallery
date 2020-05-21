package com.sample.phonebook.common.ui

import android.graphics.Bitmap
import java.lang.ref.SoftReference
import java.util.*
import kotlin.collections.HashMap


class MemoryCache {
    private val cache = Collections.synchronizedMap(HashMap<String, SoftReference<Bitmap>>())

    operator fun get(id: String): Bitmap? {
        if (!cache.containsKey(id))
            return null
        val ref = cache.get(id)
        return ref?.get()
    }

    fun put(id: String, bitmap: Bitmap?) {
        if (bitmap != null)
            cache?.put(id, SoftReference<Bitmap>(bitmap))
    }

    fun clear() {
        cache.clear()
    }
}