package com.example.tests.config

import java.util.Properties
import java.io.FileInputStream
//чтение параметров из файла test.properties в объект Properties
object TestConfig {
    private val props: Properties = Properties().apply {
        val path = "src/test/resources/test.properties"
        FileInputStream(path).use { load(it) }
    }

    val BASE_API_URL: String = props.getProperty("base.api.url")
    val BASE_UI_URL: String = props.getProperty("base.ui.url")
    val HEADLESS: Boolean = props.getProperty("headless").toBoolean()
    val IMPLICIT_WAIT: Long = props.getProperty("implicit.wait").toLong()
}
