package com.quid.QRcode.letter.service

import com.quid.QRcode.letter.domain.Letter
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface LetterService {
    fun makeQR(toLetter: Letter)

    @Service
    @Transactional
    class LetterServiceImpl : LetterService {
        override fun makeQR(toLetter: Letter) {

        }
    }
}