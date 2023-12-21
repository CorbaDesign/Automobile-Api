package com.automobile.routing

import com.automobile.data.models.serializers.DateTimeSerializer
import com.example.automobile.data.database.DatabaseConnection
import com.example.automobile.utils.types.ResponseCall
import com.example.automobile.data.tables.CarReservation
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import kotlinx.serialization.Serializable
import org.ktorm.dsl.*

@Serializable
data class CarReservationData(
    val id: Int,
    @Serializable(with = DateTimeSerializer::class)
    val dateTimeFrom: java.time.LocalDateTime,
    @Serializable(with = DateTimeSerializer::class)
    val dateTimeUntil: java.time.LocalDateTime,
    val userProfileID: Int,
    val carID: Int
)

fun Application.carReservationRoutes() {
    val db = DatabaseConnection.database

    routing {
        authenticate("auth-jwt") {
            /**
             * Get all CarReservation data
             */

            get("/carReservations") {
                val carReservation = db.from(CarReservation).select()
                    .map {
                        val id = it[CarReservation.id]!!
                        val dateTimeFrom = it[CarReservation.dateTimeFrom]!!
                        val dateTimeUntil = it[CarReservation.dateTimeUntil]!!
                        val userProfileID = it[CarReservation.userProfileID]!!
                        val carID = it[CarReservation.carID]!!

                        CarReservationData(id, dateTimeFrom, dateTimeUntil, userProfileID, carID)
                    }

                call.respond(carReservation)
            }


            /**
             * Get CarReservation data by id
             */

            get("/carReservation/{id}") {
                val id = call.parameters["id"]?.toInt() ?: -1
                val carReservation = db.from(CarReservation)
                    .select()
                    .where { CarReservation.id eq id }
                    .map {
                        val id = it[CarReservation.id]!!
                        val dateTimeFrom = it[CarReservation.dateTimeFrom]!!
                        val dateTimeUntil = it[CarReservation.dateTimeUntil]!!
                        val userProfileID = it[CarReservation.userProfileID]!!
                        val carID = it[CarReservation.carID]!!

                        CarReservationData(id, dateTimeFrom, dateTimeUntil, userProfileID, carID)
                    }.firstOrNull()

                if (carReservation == null) {
                    call.respond(
                        HttpStatusCode.NotFound,
                        ResponseCall(
                            success = false,
                            data = null
                        )
                    )
                } else {
                    call.respond(
                        HttpStatusCode.OK,
                        ResponseCall(
                            success = true,
                            data = carReservation
                        )
                    )
                }
            }
        }
    }
}