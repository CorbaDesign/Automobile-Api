package com.example.automobile.routing

import com.example.automobile.data.database.DatabaseConnection
import com.example.automobile.utils.types.ResponseCall
import com.example.automobile.data.tables.Account
import kotlinx.serialization.Serializable
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.*

@Serializable
data class AccountResponseData(
    val id: Int,
    val email: String,
    val userProfileID: Int?
)

data class AccountCreateData(
    val email: String,
    val password: String
)

fun Application.accountRoutes() {
    val db = DatabaseConnection.database

    routing {
        authenticate("auth-jwt") {
            /**
             * Get all Account data
             */

            get("/accounts") {
                val account = db.from(Account).select()
                    .map {
                        val id = it[Account.id]!!
                        val email = it[Account.email]!!
                        val userProfileID = it[Account.userProfileID]

                        AccountResponseData(id, email, userProfileID)
                    }
                call.respond(account)
            }

            /**
             * Get Account data by id
             */

            get("/account/{id}") {
                val id = call.parameters["id"]?.toInt() ?: -1
                val account = db.from(Account)
                    .select()
                    .where { Account.id eq id }
                    .map {
                        val id = it[Account.id]!!
                        val email = it[Account.email]!!
                        val userProfileID = it[Account.userProfileID]

                        AccountResponseData(id, email, userProfileID)
                    }.firstOrNull()

                if (account == null) {
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
                            data = account
                        )
                    )

                }
            }

            post("/account/create") {
                // Parse the request into an account data object
                val accountRequest = call.receive<AccountCreateData>()

                // data validation if email or password is blank
                if (accountRequest.email.isBlank() || accountRequest.password.isBlank()) {
                    call.respond(
                        HttpStatusCode.BadRequest,
                        ResponseCall (
                            success = false,
                            data = null
                        )
                    )
                    return@post
                }

                // Check if account already exists
                val existingAccount = db.from(Account)
                    .select()
                    .where { Account.email eq accountRequest.email }
                    .map { it[Account.email]!! }
                    .firstOrNull()

                if (existingAccount != null) {
                    call.respond(
                        HttpStatusCode.BadRequest,
                        ResponseCall (
                            success = false,
                            data = null
                        )
                    )
                    return@post
                }

                // Insert new account in the database if all data is valid
                val accountId = db.insertAndGenerateKey(Account) {
                    set(it.email, accountRequest.email)
                    set(it.password, accountRequest.password)
                } as Int

                call.respond(
                    HttpStatusCode.Created,
                    ResponseCall (
                        success = true,
                        data = AccountResponseData(id = accountId, email = accountRequest.email, userProfileID = null)
                    )
                )
            }

            delete("/account/{id}") {
                val id = call.parameters["id"]?.toInt()

                if (id == null) {
                    call.respond(
                        HttpStatusCode.BadRequest,
                        ResponseCall (
                            success = false,
                            data = null
                        )
                    )
                    return@delete
                }

                // check if the account exist
                val accountExists = db.from(Account)
                    .select()
                    .where { Account.id eq id }
                    .map { it[Account.id]!! }
                    .firstOrNull()

                if (accountExists != null) {
                    call.respond(
                        HttpStatusCode.NotFound,
                        ResponseCall (
                            success = false,
                            data = null
                        )
                    )
                    return@delete
                }

                // Delete the account from  the database
                db.delete(Account) {
                    it.id eq id
                }

                call.respond(
                    HttpStatusCode.OK,
                    ResponseCall (
                        success = true,
                        data = null
                    )
                )
            }
        }
    }
}


