package com.automobile.plugins

import com.automobile.routing.bonusPointsTransactionRoutes
import com.automobile.routing.carAvailabilityRoutes
import com.automobile.routing.carReservationRoutes
import com.automobile.routing.paymentRoutes
import com.example.automobile.routing.accountRoutes
import com.example.automobile.routing.authenticationRoutes
import com.example.automobile.routing.carLocationRoutes
import com.example.automobile.routing.userProfileRoutes
import com.example.data.routing.carRoutes
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText { "Your application is running!" }
        }
    }

    authenticationRoutes()
    accountRoutes()
    userProfileRoutes()
    carRoutes()
    carAvailabilityRoutes()
    carReservationRoutes()
    bonusPointsTransactionRoutes()
    paymentRoutes()
    carLocationRoutes()
}


