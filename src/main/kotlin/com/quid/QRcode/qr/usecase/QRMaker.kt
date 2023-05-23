package com.quid.QRcode.qr.usecase


import com.quid.QRcode.qr.domain.QRCode
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import javax.servlet.ServletOutputStream


interface QRMaker {
    fun make(url: String, outputStream: ServletOutputStream)

    @Service
    class SimpleQRMaker : QRMaker {
        private val logger = LoggerFactory.getLogger(SimpleQRMaker::class.java)

        override fun make(url: String, outputStream: ServletOutputStream) =
            QRCode(url).create(outputStream)
                .also { logger.info("QRCode created for $url") }
    }
}