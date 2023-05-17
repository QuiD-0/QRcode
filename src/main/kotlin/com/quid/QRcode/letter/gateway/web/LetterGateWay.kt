package com.quid.QRcode.letter.gateway.web

import com.quid.QRcode.letter.gateway.web.dto.LetterCreateRequest
import com.quid.QRcode.letter.service.LetterService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/letter")
class LetterGateWay(private val letter: LetterService) {

    @PostMapping("/write")
    fun writeLetter(@RequestBody request: LetterCreateRequest) {
        letter.makeQR(request.toLetter())
    }
}