package com.bring.poc.self.study.easter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EasterApplication

fun main(args: Array<String>) {
    runApplication<EasterApplication>(*args)
}
