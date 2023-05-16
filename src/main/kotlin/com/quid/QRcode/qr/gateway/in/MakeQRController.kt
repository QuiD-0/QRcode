package com.quid.QRcode.qr.gateway.`in`

import com.quid.QRcode.qr.usecase.QRMaker
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/qr")
class MakeQRController(private val qrMaker: QRMaker) {

    @GetMapping("/url")
    fun makeQR(@RequestParam url: String, response: HttpServletResponse) {
        qrMaker.make(url, response.outputStream)
    }

}