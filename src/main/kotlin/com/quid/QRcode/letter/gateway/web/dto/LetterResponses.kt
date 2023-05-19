package com.quid.QRcode.letter.gateway.web.dto

import com.quid.QRcode.letter.domain.Letter
import java.time.LocalDate

data class LetterResponse(
    val sender: String,
    val receiver: String,
    val content: String,
    val title: String,
    val date: LocalDate,
)

fun letterResponse(letter: Letter): LetterResponse =
    LetterResponse(letter.sender, letter.receiver, letter.content, letter.title, letter.regDate)