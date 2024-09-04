package com.github.renatocardosoalves.demoretry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RetryApplication

fun main(args: Array<String>) {
	runApplication<RetryApplication>(*args)
}
