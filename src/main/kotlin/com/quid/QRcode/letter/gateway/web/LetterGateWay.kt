package com.quid.QRcode.letter.gateway.web

import com.quid.QRcode.letter.gateway.web.dto.LetterCreateRequest
import com.quid.QRcode.letter.gateway.web.dto.LetterResponse
import com.quid.QRcode.letter.gateway.web.dto.letterResponse
import com.quid.QRcode.letter.usecase.LetterCreate
import com.quid.QRcode.letter.usecase.LetterRead
import org.springframework.web.bind.annotation.*
import javax.servlet.ServletOutputStream

@RestController
@RequestMapping("/letter")
class LetterGateWay(
    private val readLetter: LetterRead,
    private val createLetter: LetterCreate
) {

    @PostMapping("/write")
    fun writeLetter(@RequestBody request: LetterCreateRequest, outputStream: ServletOutputStream) =
        createLetter.makeQr(request.toLetter(), outputStream)

    @GetMapping("/{id}")
    fun readLetter(@PathVariable id: String) : LetterResponse = letterResponse(readLetter.by(id))

}