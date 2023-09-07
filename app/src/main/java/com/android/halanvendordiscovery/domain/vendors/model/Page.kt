package com.android.halanvendordiscovery.domain.vendors.model

data class Page(val number: Int) {
    fun increment(): Page = Page(number + 1)

    companion object {
        fun initial(): Page = Page(-1)
    }
}
