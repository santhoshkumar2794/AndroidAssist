package com.zestworks.android

import com.zestworks.assist.recyclerview.AdapterItem
import com.zestworks.assist.recyclerview.ImageURL

val adapterItems = mutableListOf<AdapterItem>(
        AdapterItem("Bottom App Bar", ImageURL(resourcePath = R.mipmap.ic_bottomappbar)),
        AdapterItem("Top App Bar", ImageURL(resourcePath = R.mipmap.ic_topappbar)),
        AdapterItem("Bottom Navigation", ImageURL(resourcePath = R.mipmap.ic_bottomnavigation)),
        AdapterItem("Cards", ImageURL(resourcePath = R.mipmap.ic_card)),
        AdapterItem("Side Drawer", ImageURL(resourcePath = R.mipmap.ic_side_drawer)),
        AdapterItem("Tab Layout", ImageURL(resourcePath = R.mipmap.ic_tabs))
)