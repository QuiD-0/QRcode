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
    private val receiver: String,
    private val content: String,
    private val title: String,
    private val regDate: LocalDate
){
    fun toLetter() = Letter(sender,receiver, title, content, regDate, id.toHexString())

}

fun document(letter: Letter) = LetterDocument(
    letter.id?.let { ObjectId(it) } ?: ObjectId.get(),
    letter.sender,
    letter.receiver,
    letter.content,
    letter.title,
    letter.regDate)