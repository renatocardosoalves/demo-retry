package com.github.renatocardosoalves.demoretry

import org.slf4j.LoggerFactory
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Recover
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service

@Service
class ApiService {

    private val logger = LoggerFactory.getLogger(ApiService::class.java)

    @Retryable(
        value = [ApiException::class],
        maxAttempts = 3,
        backoff = Backoff(2000)
    )
    fun callExternalApi() {
        logger.info("Calling external api...")
        throw ApiException("Error calling external api")
    }

    @Recover
    fun recover(exception: ApiException): String {
        logger.error("Recovering from error calling external api: ${exception.message}")
        return "Recovering from error calling external api"
    }
}