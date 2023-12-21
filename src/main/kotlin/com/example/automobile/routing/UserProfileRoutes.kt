package com.example.automobile.routing

import com.automobile.data.models.serializers.DateSerializer
import com.example.automobile.data.database.DatabaseConnection
import com.example.automobile.utils.types.ResponseCall
import com.example.automobile.data.tables.UserProfile
import kotlinx.serialization.Serializable

import java.time.LocalDate

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.*

@Serializable
data class UserProfileData(
    val id: Int,
    val firstName: String,
    val lastName: String,
    @Serializable(with = DateSerializer::class)
    val dateOfBirth: LocalDate,
    val driversLicenceNumber: Int
)

fun Application.userProfileRoutes() {
    val db = DatabaseConnection.database

    routing {
        authenticate("auth-jwt") {
            /**
             * Get all UserProfile data
             */

            get("/users") {
                val users = db.from(UserProfile).select()
                    .map {
                        val id = it[UserProfile.id]!!
                        val firstName = it[UserProfile.firstName]!!
                        val lastName = it[UserProfile.lastName]!!
                        val dateOfBirth = it[UserProfile.dateOfBirth]!!
                        val driversLicenceNumber = it[UserProfile.driversLicenceNumber]!!

                        UserProfileData(id, firstName, lastName, dateOfBirth, driversLicenceNumber)
                    }
                call.respond(users)
            }


            /**
             * Get UserProfile data by id
             */

            get("/user/{id}") {
                val id = call.parameters["id"]?.toInt() ?: -1
                val user = db.from(UserProfile)
                    .select()
                    .where { UserProfile.id eq id }
                    .map {
                        val id = it[UserProfile.id]!!
                        val firstName = it[UserProfile.firstName]!!
                        val lastName = it[UserProfile.lastName]!!
                        val dateOfBirth = it[UserProfile.dateOfBirth]!!
                        val driversLicenceNumber = it[UserProfile.driversLicenceNumber]!!

                        UserProfileData(id, firstName, lastName, dateOfBirth, driversLicenceNumber)
                    }.firstOrNull()

                if (user == null) {
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
                            data = user
                        )
                    )
                }
            }
        }
    }
}