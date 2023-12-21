package com.example.automobile.routing

import com.example.automobile.data.database.DatabaseConnection
import com.example.automobile.data.database.DatabaseConnection.accounts
import com.example.automobile.data.entities.AccountEntity
import com.example.automobile.utils.types.ResponseCall
import com.example.automobile.data.tables.Account
import com.example.automobile.utils.TokenManager
import com.typesafe.config.ConfigFactory
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.config.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import org.ktorm.dsl.*
import org.ktorm.entity.add
import org.mindrot.jbcrypt.BCrypt

@Serializable
data class AuthenticationData(
    var email: String,
    var password: String
) {
     // Function that creates a hash from a String using the BCrypt package
    fun hashedPassword(): String {
        return BCrypt.hashpw(password, BCrypt.gensalt())
    }
}

fun Application.authenticationRoutes() {
    val db = DatabaseConnection.database
    val tokenManager = TokenManager(HoconApplicationConfig(ConfigFactory.load()))

    routing {
        /**
         * Register an account
         */

        post("/register") {
            val accountData = call.receive<AuthenticationData>()

            val account = AccountEntity {
                email = accountData.email
                password = accountData.hashedPassword()


                // Check if email already exists in the database
                val user = db.from(Account)
                    .select()
                    .where( Account.email eq email)
                    .map { it[Account.email] }
                    .firstOrNull()

                // If user already exists; give a BadRequest response call
                if(user != null) {
                    call.respond(HttpStatusCode.BadRequest,
                        ResponseCall(success = false, data = "Email already exists, please try a different email")
                    )
                        return@post
                }

            }

            // Add data to the database
            db.accounts.add(account)

            // Give a Created response call
             call.respond(HttpStatusCode.Created,
                 ResponseCall(success = true, data = "User has been successfully created")
             )
        }


        /**
         * Log into an account
         */

        post("/login") {
            val accountData = call.receive<AuthenticationData>()

            val account = AccountEntity {
                email = accountData.email
                password = accountData.password

                // Check if user exists
                val user = db.from(Account)
                    .select()
                    .where( Account.email eq email)
                    .map {
                        val email = it[Account.email]!!
                        val password = it[Account.password]!!

                        AuthenticationData(email, password)
                    }.firstOrNull()

                // If user does not match, give BadRequest
                if(user == null) {
                    call.respond(HttpStatusCode.BadRequest,
                        ResponseCall(success = false, data = "Invalid e-mail address or password")
                    )
                    return@post
                }

                // Check if password matches with BCrypt module
                val doesPasswordMatch = BCrypt.checkpw(password, user?.password)
                // If password does not match, give BadRequest
                if(!doesPasswordMatch) {
                    call.respond(HttpStatusCode.BadRequest,
                        ResponseCall(success = false, data = "Invalid e-mail address or password")
                    )
                    return@post
                }

                // Create token
                val token = tokenManager.generateJWTToken(user)

                //If password does match, give OK and give token
                call.respond(HttpStatusCode.OK,
                    ResponseCall(success = true, data = token)
                )
            }
        }

        /**
         * Authenticate an account
         */

        authenticate("auth-jwt") {
            get("/me") {
                val principal = call.principal<JWTPrincipal>()
                val email = principal!!.payload.getClaim("email").asString()
                call.respondText("Hello, $email", ContentType.Application.Json)
            }
        }
    }
}