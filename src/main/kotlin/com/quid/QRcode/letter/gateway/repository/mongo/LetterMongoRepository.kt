package com.quid.QRcode.letter.gateway.repository.mongo

import com.quid.QRcode.letter.gateway.repository.LetterDocument
import org.bson.types.ObjectId
import org.springframework.data.repository.CrudRepository

interface LetterMongoRepository : CrudRepository<LetterDocument, ObjectId> {
}