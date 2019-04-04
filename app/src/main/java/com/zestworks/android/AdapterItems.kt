package com.zestworks.android

import com.zestworks.assist.recyclerview.AdapterItem
import com.zestworks.assist.recyclerview.ImageURL

val adapterItems = mutableListOf<AdapterItem>(
        AdapterItem("Bottom App Bar", ImageURL(resourcePath = R.mipmap.ic_bottomappbar)),
        AdapterItem("Top App Bar", ImageURL(resourcePath = R.mipmap.ic_topappbar))
)