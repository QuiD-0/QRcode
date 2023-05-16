package com.quid.QRcode.qr.usecase


import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.common.BitMatrix
import org.springframework.stereotype.Service
import javax.servlet.ServletOutputStream


interface QRMaker {
    fun make(url: String, outputStream: ServletOutputStream)

    @Service
    class SimpleQRMaker : QRMaker {
        override fun make(url: String, outputStream: ServletOutputStream) {
            val matrix: BitMatrix =
                MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 200, 200)
            MatrixToImageWriter.writeToStream(matrix, "PNG", outputStream)
            outputStream.flush()
        }
    }
}