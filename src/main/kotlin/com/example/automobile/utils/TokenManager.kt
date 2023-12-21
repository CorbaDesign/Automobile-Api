package com.example.automobile.utils

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.example.automobile.routing.AuthenticationData
import io.ktor.server.config.*
import java.util.Date

class TokenManager (val config: HoconApplicationConfig) {
    val secret = config.property("secret").getString()
    val issuer = config.property("issuer").getString()
    val audience = config.property("audience").getString()
    val experationDate = System.currentTimeMillis() + 10000000000000; // Expires every minute

    fun generateJWTToken(user: AuthenticationData): String {
        // Create token
        val token =  JWT.create()
            .withAudience(audience)
            .withIssuer(issuer)
            .withClaim("email", user.email)
            .withExpiresAt(Date(experationDate))
            .sign(Algorithm.HMAC256(secret))
        return token
    }

    fun verifyJWTToken(): JWTVerifier {
        return JWT.require(Algorithm.HMAC256(secret))
            .withAudience(audience)
            .withIssuer(issuer)
            .build()
    }
}