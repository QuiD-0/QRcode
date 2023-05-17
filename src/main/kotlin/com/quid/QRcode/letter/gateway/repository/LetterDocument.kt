package com.quid.QRcode.letter.gateway.repository

import com.quid.QRcode.letter.domain.Letter
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document
class LetterDocument(
    @Id
    private val id : ObjectId,
    private val sender: String,
    private val content: String,
    private val title: String,
    private val regDate: LocalDate
){
    fun toLetter() = Letter(sender, title, content, regDate, id.toHexString())

    fun toDocument(letter: Letter) = LetterDocument(
        letter.id?.let { ObjectId(it) } ?: ObjectId.get(),
        letter.sender,
        letter.content,
        letter.title,
        letter.regDate)
}