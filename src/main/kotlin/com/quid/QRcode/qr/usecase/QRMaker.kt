package com.quid.QRcode.qr.usecase


import com.quid.QRcode.qr.domain.QRCode
import org.springframework.stereotype.Service
import javax.servlet.ServletOutputStream


interface QRMaker {
    fun make(url: String, outputStream: ServletOutputStream)

    @Service
    class SimpleQRMaker : QRMaker {
        override fun make(url: String, outputStream: ServletOutputStream) =
            QRCode(url).create(outputStream)
    }
}