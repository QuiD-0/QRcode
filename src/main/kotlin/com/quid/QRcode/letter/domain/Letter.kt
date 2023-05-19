package com.quid.QRcode.letter.domain

import java.time.LocalDate

class Letter(
    val sender: String,
    val receiver : String,
    val title: String,
    val content: String,
    val regDate: LocalDate,
    val id : String? = null,
) {
    fun toUrl(): String {
        return "http://130.162.136.116/letter/$id"
    }

    init {
        if (content.length > 1000) {
            throw IllegalArgumentException("글자수가 1000자를 초과했습니다.")
        }
    }
}