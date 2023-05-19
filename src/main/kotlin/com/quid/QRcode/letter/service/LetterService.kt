package com.quid.QRcode.letter.service

import com.quid.QRcode.letter.domain.Letter
import com.quid.QRcode.letter.gateway.repository.LetterRepository
import com.quid.QRcode.qr.usecase.QRMaker
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.servlet.ServletOutputStream

interface LetterService {
    fun makeQR(letter: Letter, outputStream: ServletOutputStream)
    fun readLetter(id: String): Letter

    @Service
    @Transactional
    class LetterServiceImpl(private val letterRepository: LetterRepository,
        private val qr: QRMaker) : LetterService {
        @Value("\${domain}")
        private val domain = "http://localhost:8080"

        override fun makeQR(letter: Letter, outputStream: ServletOutputStream) {
            letterRepository.save(letter).let {
                qr.make(it.toUrl(domain), outputStream)
            }
        }

        override fun readLetter(id: String): Letter {
            return letterRepository.findById(id)
        }
    }
}