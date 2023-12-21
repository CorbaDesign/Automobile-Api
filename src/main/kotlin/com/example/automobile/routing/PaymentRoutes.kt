package com.automobile.routing

import com.automobile.data.models.serializers.DateTimeSerializer
import com.example.automobile.data.database.DatabaseConnection
import com.example.automobile.utils.types.ResponseCall
import com.example.automobile.data.tables.Payment
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import org.ktorm.dsl.*

@Serializable
data class PaymentData(
    val id: Int,
    val amount: Double,
    val currency: String,
    val paymentMethod: String,
    @Serializable(with = DateTimeSerializer::class)
    val dateTime: java.time.LocalDateTime,
    val carReservationID: Int
)

fun Application.paymentRoutes() {
    val db = DatabaseConnection.database

    routing {
        authenticate("auth-jwt") {
            /**
             * Get all Payment data
             */

            get("/payments") {
                val payment = db.from(Payment).select()
                    .map {
                        val id = it[Payment.id]!!
                        val amount = it[Payment.amount]!!
                        val currency = it[Payment.currency]!!
                        val paymentMethod = it[Payment.paymentMethod]!!
                        val dateTime = it[Payment.dateTime]!!
                        val carReservationID = it[Payment.carReservationID]!!

                        PaymentData(id, amount, currency, paymentMethod, dateTime, carReservationID)
                    }

                call.respond(payment)
            }


            /**
             * Get Payment data by id
             */

            get("/payment/{id}") {
                val id = call.parameters["id"]?.toInt() ?: -1
                val payment = db.from(Payment)
                    .select()
                    .where { Payment.id eq id }
                    .map {
                        val id = it[Payment.id]!!
                        val amount = it[Payment.amount]!!
                        val currency = it[Payment.currency]!!
                        val paymentMethod = it[Payment.paymentMethod]!!
                        val dateTime = it[Payment.dateTime]!!
                        val carReservationID = it[Payment.carReservationID]!!
                        PaymentData(id, amount, currency, paymentMethod, dateTime, carReservationID)
                    }.firstOrNull()

                if (payment == null) {
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
                            data = payment
                        )
                    )
                }
            }
        }
    }
}