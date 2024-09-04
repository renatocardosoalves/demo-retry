package com.github.renatocardosoalves.demoretry

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.retry.annotation.EnableRetry

@SpringBootApplication
@EnableRetry
class RetryApplication {

    private val logger = LoggerFactory.getLogger(RetryApplication::class.java)

    @Bean
    fun run(apiService: ApiService): CommandLineRunner {
        return CommandLineRunner {
            try {
                val response = apiService.callExternalApi()
                logger.info("Response: $response")
            } catch (e: Exception) {
                logger.error("Error: ${e.message}")
            }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<RetryApplication>(*args)
}