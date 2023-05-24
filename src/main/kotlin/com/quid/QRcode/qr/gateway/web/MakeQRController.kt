package com.quid.QRcode.qr.gateway.web

import com.quid.QRcode.qr.domain.QRCode
import com.quid.QRcode.qr.gateway.web.dto.UrlCreateRequest
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/qr")
class MakeQRController {
    @PostMapping("/url")
    fun makeQR(@RequestBody request: UrlCreateRequest, response: HttpServletResponse) {
        QRCode(request.url).download(response.outputStream)
    }

}