package com.quid.QRcode.letter.usecase

import com.quid.QRcode.letter.domain.Letter
import com.quid.QRcode.letter.gateway.repository.LetterRepository
import com.quid.QRcode.qr.domain.QRCode
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.servlet.ServletOutputStream

interface LetterCreate {
    fun makeQr(letter: Letter, outputStream: ServletOutputStream)

    @Service
    @Transactional
    class LetterCreateImpl(
        private val letterRepository: LetterRepository,
    ) : LetterCreate {

        @Value("\${domain}")
        private lateinit var domain: String

        override fun makeQr(letter: Letter, outputStream: ServletOutputStream) =
            letterRepository.save(letter)
                .let { QRCode(it.toUrl(domain)).download(outputStream) }
    }
}