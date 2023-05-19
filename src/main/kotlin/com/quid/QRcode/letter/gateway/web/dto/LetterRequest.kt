package com.quid.QRcode.letter.gateway.web.dto

import com.quid.QRcode.letter.domain.Letter
import java.time.LocalDate

data class LetterCreateRequest(
    val sender: String = "익명",
    val receiver: String,
    val content: String,
    val title: String,
) {
    fun toLetter() = Letter(sender, receiver, title, content, LocalDate.now())
}