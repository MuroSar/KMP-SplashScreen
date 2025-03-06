package com.murosar.kmp.splashscreen

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform