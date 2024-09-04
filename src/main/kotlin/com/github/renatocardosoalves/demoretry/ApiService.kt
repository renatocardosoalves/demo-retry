package com.github.renatocardosoalves.demoretry

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ApiService {

    private val logger = LoggerFactory.getLogger(ApiService::class.java)

    fun callExternalApi() {
        logger.info("Calling external api...")
        throw ApiException("Error calling external api")
    }
}