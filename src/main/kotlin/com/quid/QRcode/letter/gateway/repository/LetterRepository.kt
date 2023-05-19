package com.quid.QRcode.letter.gateway.repository

import com.quid.QRcode.letter.domain.Letter
import com.quid.QRcode.letter.gateway.repository.mongo.LetterMongoRepository
import org.springframework.stereotype.Repository

interface LetterRepository {
    fun save(letter: Letter): Letter

    @Repository
    class LetterRepositoryImpl(private val mongoRepository: LetterMongoRepository) : LetterRepository {
        override fun save(letter: Letter): Letter = mongoRepository.save(document(letter)).toLetter()
    }
}