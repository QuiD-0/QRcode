package com.quid.QRcode.qr.gateway.web

import com.quid.QRcode.qr.gateway.web.dto.UrlCreateRequest
import com.quid.QRcode.qr.usecase.QRMaker
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/qr")
class MakeQRController(private val qrMaker: QRMaker) {

    @PostMapping("/url")
    fun makeQR(@RequestBody request: UrlCreateRequest, response: HttpServletResponse) {
        qrMaker.make(request.url, response.outputStream)
    }

}