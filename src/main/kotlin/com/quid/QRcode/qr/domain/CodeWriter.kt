package com.quid.QRcode.qr.domain

import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.common.BitMatrix
import org.slf4j.LoggerFactory
import javax.servlet.ServletOutputStream

class CodeWriter(
    private val content: String,
) {
    private lateinit var matrix: BitMatrix
    private val logger = LoggerFactory.getLogger(CodeWriter::class.java)

    init {
        require(content.isNotBlank()) { "content must not be blank" }
    }

    fun generate(format: BarcodeFormat) =
        this.apply { matrix = MultiFormatWriter().encode(content, format, 200, 200) }
            .also { logger.info("Code created $content type $format") }

    fun download(outputStream: ServletOutputStream) =
        MatrixToImageWriter.writeToStream(matrix, "png", outputStream)

}