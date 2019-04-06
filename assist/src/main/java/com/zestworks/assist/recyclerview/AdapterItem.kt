package com.zestworks.assist.recyclerview

import java.io.File

data class AdapterItem(
        val title: String = "",
        val imageUrl: ImageURL = ImageURL()
)

data class ImageURL(
        val url: String? = null,
        val filePath: File? = null,
        val resourcePath: Int? = null
)