package com.automobile.routing

import com.example.automobile.data.database.DatabaseConnection
import com.example.automobile.utils.types.ResponseCall
import com.example.automobile.data.tables.BonusPointsTransaction
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import kotlinx.serialization.Serializable
import org.ktorm.dsl.*

@Serializable
data class BonusPointsTransactionData(
    val id: Int,
    val amount: Int,
    val userProfileID: Int,
    val carReservationID: Int
)

fun Application.bonusPointsTransactionRoutes() {
    val db = DatabaseConnection.database

    routing {
        authenticate("auth-jwt") {
            /**
             * Get all BonusPointsTransaction data
             */

            get("/bonusPointsTransactions") {
                val bonusPointsTransaction = db.from(BonusPointsTransaction).select()
                    .map {
                        val id = it[BonusPointsTransaction.id]!!
                        val amount = it[BonusPointsTransaction.amount]!!
                        val userProfileID = it[BonusPointsTransaction.userProfileID]!!
                        val carReservationID = it[BonusPointsTransaction.carReservationID]!!

                        BonusPointsTransactionData(id, amount, userProfileID, carReservationID)
                    }

                call.respond(bonusPointsTransaction)
            }


            /**
             * Get BonusPointsTransaction data by id
             */

            get("/bonusPointsTransaction/{id}") {
                val id = call.parameters["id"]?.toInt() ?: -1
                val bonusPointsTransaction = db.from(BonusPointsTransaction)
                    .select()
                    .where { BonusPointsTransaction.id eq id }
                    .map {
                        val id = it[BonusPointsTransaction.id]!!
                        val amount = it[BonusPointsTransaction.amount]!!
                        val userProfileID = it[BonusPointsTransaction.userProfileID]!!
                        val carReservationID = it[BonusPointsTransaction.carReservationID]!!

                        BonusPointsTransactionData(id, amount, userProfileID, carReservationID)
                    }.firstOrNull()

                if (bonusPointsTransaction == null) {
                    call.respond (
                        HttpStatusCode.NotFound,
                        ResponseCall (
                            success = false,
                            data = null
                        )
                    )
                } else {
                    call.respond(
                        HttpStatusCode.OK,
                        ResponseCall (
                            success = true,
                            data = bonusPointsTransaction
                        )
                    )
                }
            }
        }
    }
}