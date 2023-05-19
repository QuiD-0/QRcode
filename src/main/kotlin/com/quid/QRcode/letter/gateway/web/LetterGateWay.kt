package com.quid.QRcode.letter.gateway.web

import com.quid.QRcode.letter.gateway.web.dto.LetterCreateRequest
import com.quid.QRcode.letter.gateway.web.dto.LetterResponse
import com.quid.QRcode.letter.gateway.web.dto.letterResponse
import com.quid.QRcode.letter.service.LetterService
import org.springframework.web.bind.annotation.*
import javax.servlet.ServletOutputStream

@RestController
@RequestMapping("/letter")
class LetterGateWay(private val letter: LetterService) {

    @PostMapping("/write")
    fun writeLetter(@RequestBody request: LetterCreateRequest, outputStream: ServletOutputStream) =
        letter.makeQR(request.toLetter(), outputStream)

    @GetMapping("/{id}")
    fun readLetter(@PathVariable id: String) : LetterResponse = letterResponse(letter.readLetter(id))

}