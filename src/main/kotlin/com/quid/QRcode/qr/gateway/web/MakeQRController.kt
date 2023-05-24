package com.quid.QRcode.qr.gateway.web

import com.google.zxing.BarcodeFormat.QR_CODE
import com.quid.QRcode.qr.domain.CodeWriter
import com.quid.QRcode.qr.gateway.web.dto.UrlCreateRequest
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/qr")
class MakeQRController {
    @PostMapping("/url")
    fun makeQR(@RequestBody request: UrlCreateRequest, response: HttpServletResponse) {
        CodeWriter(request.url).generate(QR_CODE).download(response.outputStream)
    }

}