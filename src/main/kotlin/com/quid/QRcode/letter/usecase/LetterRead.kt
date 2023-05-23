package com.quid.QRcode.letter.usecase

import com.quid.QRcode.letter.domain.Letter
import com.quid.QRcode.letter.gateway.repository.LetterRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface LetterRead {
    fun by(id: String): Letter

    @Service
    @Transactional(readOnly = true)
    class LetterReadImpl(
        private val letterRepository: LetterRepository,
    ) : LetterRead {

        override fun by(id: String): Letter {
            return letterRepository.findById(id)
        }
    }
}