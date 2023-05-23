package com.quid.QRcode.qr.domain

import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.client.j2se.MatrixToImageWriter
import javax.servlet.ServletOutputStream

class QRCode(
    private val content: String,
) {
    fun create(outputStream: ServletOutputStream) {
        MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 200, 200).let {
            MatrixToImageWriter.writeToStream(it, "PNG", outputStream)
            outputStream.flush()
        }
    }
}