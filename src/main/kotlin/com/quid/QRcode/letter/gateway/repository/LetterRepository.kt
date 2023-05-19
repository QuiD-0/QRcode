package com.quid.QRcode.letter.gateway.repository

import com.quid.QRcode.letter.domain.Letter
import com.quid.QRcode.letter.gateway.repository.mongo.LetterMongoRepository
import org.bson.types.ObjectId
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

interface LetterRepository {
    fun save(letter: Letter): Letter
    fun findById(id: String): Letter

    @Repository
    class LetterRepositoryImpl(private val mongoRepository: LetterMongoRepository) :
        LetterRepository {
        override fun save(letter: Letter): Letter =
            mongoRepository.save(document(letter)).toLetter()

        override fun findById(id: String): Letter = mongoRepository.findByIdOrNull(ObjectId(id))?.toLetter()
                ?: throw IllegalArgumentException("존재하지 않는 편지입니다.")
    }
}