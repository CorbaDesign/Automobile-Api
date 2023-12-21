package com.automobile.routing

import com.automobile.data.models.serializers.DateTimeSerializer
import com.example.automobile.data.database.DatabaseConnection
import com.example.automobile.utils.types.ResponseCall
import com.example.automobile.data.tables.CarAvailability
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import kotlinx.serialization.Serializable
import org.ktorm.dsl.*

@Serializable
data class CarAvailabilityData(
    val id: Int,
    @Serializable(with = DateTimeSerializer::class)
    val dateTimeFrom: java.time.LocalDateTime,
    @Serializable(with = DateTimeSerializer::class)
    val dateTimeUntil: java.time.LocalDateTime,
    val carID: Int
)

fun Application.carAvailabilityRoutes() {
    val db = DatabaseConnection.database

    routing {
        authenticate("auth-jwt") {
            /**
             * Get all CarAvailability data
             */

            get("/carAvailabilities") {
                val carAvailability = db.from(CarAvailability).select()
                    .map {
                        val id = it[CarAvailability.id]!!
                        val dateTimeFrom = it[CarAvailability.dateTimeFrom]!!
                        val dateTimeUntil = it[CarAvailability.dateTimeUntil]!!
                        val carID = it[CarAvailability.carID]!!

                        CarAvailabilityData(id, dateTimeFrom, dateTimeUntil, carID)
                    }

                call.respond(carAvailability)
            }


            /**
             * Get CarAvailability data by id
             */

            get("/carAvailability/{id}") {
                val id = call.parameters["id"]?.toInt() ?: -1
                val carAvailability = db.from(CarAvailability)
                    .select()
                    .where { CarAvailability.id eq id }
                    .map {
                        val id = it[CarAvailability.id]!!
                        val dateTimeFrom = it[CarAvailability.dateTimeFrom]!!
                        val dateTimeUntil = it[CarAvailability.dateTimeUntil]!!
                        val carID = it[CarAvailability.carID]!!

                        CarAvailabilityData(id, dateTimeFrom, dateTimeUntil, carID)
                    }.firstOrNull()

                if (carAvailability == null) {
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
                            data = carAvailability
                        )
                    )
                }
            }
        }
    }
}