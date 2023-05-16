package com.quid.QRcode.qr.domain

import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.client.j2se.MatrixToImageWriter
import javax.servlet.ServletOutputStream

class QRCode {
    companion object {
        fun make(contents: String, outputStream: ServletOutputStream) {
            MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, 200, 200).let {
                MatrixToImageWriter.writeToStream(it, "PNG", outputStream)
                outputStream.flush()
            }
        }
    }
}