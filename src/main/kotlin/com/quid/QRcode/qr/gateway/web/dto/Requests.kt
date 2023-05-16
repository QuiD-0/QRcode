package com.quid.QRcode.qr.gateway.web.dto

data class UrlCreateRequest(
    val url: String
){
    init {
        val regex = Regex("(https?://)?(www\\.)?[-a-zA-Z0-9@:%._+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_+.~#?&/=]*)")
        if (!regex.matches(url)) {
            throw IllegalArgumentException("url 형식이 올바르지 않습니다.")
        }
    }
}