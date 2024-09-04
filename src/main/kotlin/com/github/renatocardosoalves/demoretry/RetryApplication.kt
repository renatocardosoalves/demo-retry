package com.github.renatocardosoalves.demoretry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.retry.annotation.EnableRetry

@SpringBootApplication
@EnableRetry
class RetryApplication

fun main(args: Array<String>) {
	runApplication<RetryApplication>(*args)
}
