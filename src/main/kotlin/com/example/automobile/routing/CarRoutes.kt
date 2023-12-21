package com.example.data.routing

import com.automobile.routing.PaymentData
import com.example.automobile.data.database.DatabaseConnection
import com.example.automobile.data.tables.Car
import com.example.automobile.utils.types.ResponseCall
import kotlinx.serialization.Serializable
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import org.ktorm.dsl.*

@Serializable
data class CarData(
    val id: Int,
    val licencePlate: String,
    val carBrand: String,
    val vehicleType: String,
    val amountOfPassengers: Int,
    val amountOfDoors: Int,
    val automatic: Boolean,
    val gpsAvailable: Boolean,
    val carPriceAmount: Double,
    val carPriceCurrency: String,
    val userProfileID: Int
)

fun Application.carRoutes() {
    val db = DatabaseConnection.database

    routing {
//        authenticate("auth-jwt") {

            /**
             * Get all Car data
             */

            get("/cars") {
                val cars = db.from(Car).select()
                    .map {
                        val id = it[Car.id]!!
                        val licencePlate = it[Car.licencePlate]!!
                        val carBrand = it[Car.carBrand]!!
                        val vehicleType = it[Car.vehicleType]!!
                        val amountOfPassengers = it[Car.amountOfPassengers]!!
                        val amountOfDoors = it[Car.amountOfDoors]!!
                        val automatic = it[Car.automatic]!!
                        val gpsAvailable = it[Car.gpsAvailable]!!
                        val carPriceAmount = it[Car.carPriceAmount]!!
                        val carPriceCurrency = it[Car.carPriceCurrency]!!
                        val userProfileID = it[Car.userProfileID]!!

                        CarData(
                            id,
                            licencePlate,
                            carBrand,
                            vehicleType,
                            amountOfPassengers,
                            amountOfDoors,
                            automatic,
                            gpsAvailable,
                            carPriceAmount,
                            carPriceCurrency,
                            userProfileID
                        )
                    }

                call.respond(cars)
            }


            /**
             * Get Car data by id
             */

            get("/car/{id}") {
                val id = call.parameters["id"]?.toInt() ?: -1
                val car = db.from(Car)
                    .select()
                    .where { Car.id eq id }
                    .map {
                        val id = it[Car.id]!!
                        val licencePlate = it[Car.licencePlate]!!
                        val carBrand = it[Car.carBrand]!!
                        val vehicleType = it[Car.vehicleType]!!
                        val amountOfPassengers = it[Car.amountOfPassengers]!!
                        val amountOfDoors = it[Car.amountOfDoors]!!
                        val automatic = it[Car.automatic]!!
                        val gpsAvailable = it[Car.gpsAvailable]!!
                        val carPriceAmount = it[Car.carPriceAmount]!!
                        val carPriceCurrency = it[Car.carPriceCurrency]!!
                        val userProfileID = it[Car.userProfileID]!!

                        CarData(
                            id,
                            licencePlate,
                            carBrand,
                            vehicleType,
                            amountOfPassengers,
                            amountOfDoors,
                            automatic,
                            gpsAvailable,
                            carPriceAmount,
                            carPriceCurrency,
                            userProfileID
                        )
                    }.firstOrNull()

                if (car == null) {
                    call.respond(
                        HttpStatusCode.NotFound,
                        ResponseCall(
                            success = false,
                            data = "There is no car found with id: $id"
                        )
                    )
                } else {
                    call.respond(
                        HttpStatusCode.OK,
                        ResponseCall(
                            success = true,
                            data = car
                        )
                    )

                }
            }


            /**
             * Post Car data
             */

            post("/car") {
                val myCar = call.receive<CarData>()
                // Check if car exists
                val car = db.from(Car)
                    .select()
                    .where(myCar.licencePlate eq Car.licencePlate)
                    .map { it[Car.licencePlate] }
                    .firstOrNull()
                if (car != null) {
                    call.respond(
                        HttpStatusCode.Conflict,
                        ResponseCall(
                            success = false,
                            data = "There is already a car with this licence plate: ${myCar.licencePlate}"
                        )
                    )
                    return@post
                }

                val result = db.insert(Car) {
                    set(it.licencePlate, myCar.licencePlate)
                    set(it.carBrand, myCar.carBrand)
                    set(it.vehicleType, myCar.vehicleType)
                    set(it.amountOfPassengers, myCar.amountOfPassengers)
                    set(it.amountOfDoors, myCar.amountOfDoors)
                    set(it.automatic, myCar.automatic)
                    set(it.gpsAvailable, myCar.gpsAvailable)
                    set(it.carPriceAmount, myCar.carPriceAmount)
                    set(it.carPriceCurrency, myCar.carPriceCurrency)
                    set(it.userProfileID, myCar.userProfileID)
                }

                if (result == 1) {
                    // Send successful result to client
                    call.respond(
                        HttpStatusCode.OK,
                        ResponseCall(
                            success = true,
                            data = "Your car is saved in our database"
                        )
                    )
                } else {
                    // Send failure result to client
                    call.respond(
                        HttpStatusCode.BadRequest,
                        ResponseCall(
                            success = false,
                            data = "Sorry something went wrong. Couln't save your car"
                        )
                    )
                }
            }


            /**
             * Delete Car data by licencePlate
             */

            delete("/car/{licencePlate}") {
                val licencePlate = call.parameters["licencePlate"]?.toString() ?: ""
                val response = db.delete(Car) {
                    it.licencePlate eq licencePlate
                }
                if (response == 1) {
                    call.respond(
                        HttpStatusCode.OK,
                        ResponseCall(
                            success = true,
                            data = "Successfully deleted car with licencePlate: $licencePlate"
                        )
                    )

                } else {
                    call.respond(
                        HttpStatusCode.NotFound,
                        ResponseCall(
                            success = false,
                            data = "There was no car with licencePlate: $licencePlate"
                        )
                    )
                }
            }


            /**
             * Get Car data by licencePlate
             */

            get("/car/plate/{licencePlate}") {
                val licencePlate = call.parameters["licencePlate"] ?: ""
                val car = db.from(Car)
                    .select()
                    .where { Car.licencePlate eq licencePlate }
                    .map {
                        val id = it[Car.id]!!
                        val licencePlate = it[Car.licencePlate]!!
                        val carBrand = it[Car.carBrand]!!
                        val vehicleType = it[Car.vehicleType]!!
                        val amountOfPassengers = it[Car.amountOfPassengers]!!
                        val amountOfDoors = it[Car.amountOfDoors]!!
                        val automatic = it[Car.automatic]!!
                        val gpsAvailable = it[Car.gpsAvailable]!!
                        val carPriceAmount = it[Car.carPriceAmount]!!
                        val carPriceCurrency = it[Car.carPriceCurrency]!!
                        val userProfileID = it[Car.userProfileID]!!

                        CarData(
                            id,
                            licencePlate,
                            carBrand,
                            vehicleType,
                            amountOfPassengers,
                            amountOfDoors,
                            automatic,
                            gpsAvailable,
                            carPriceAmount,
                            carPriceCurrency,
                            userProfileID
                        )
                    }.firstOrNull()

                if (car == null) {
                    call.respond(
                        HttpStatusCode.NotFound,
                        ResponseCall(
                            success = false,
                            data = "No car available with licence plate: $licencePlate"
                        )
                    )
                } else {
                    call.respond(
                        HttpStatusCode.OK,
                        ResponseCall(
                            success = true,
                            data = car
                        )
                    )

                }
            }


            /**
             * Update Car data by licencePlate
             */

            put("/car/{licencePlate}") {
                val licencePlate = call.parameters["licencePlate"]?.toString() ?: ""
                val myCar = call.receive<CarData>()
                val result = db.update(Car) {
                    set(it.licencePlate, myCar.licencePlate)
                    set(it.carBrand, myCar.carBrand)
                    set(it.vehicleType, myCar.vehicleType)
                    set(it.amountOfPassengers, myCar.amountOfPassengers)
                    set(it.amountOfDoors, myCar.amountOfDoors)
                    set(it.automatic, myCar.automatic)
                    set(it.gpsAvailable, myCar.gpsAvailable)
                    set(it.carPriceAmount, myCar.carPriceAmount)
                    set(it.carPriceCurrency, myCar.carPriceCurrency)
                    set(it.userProfileID, myCar.userProfileID)
                    where {
                        it.licencePlate eq licencePlate
                    }
                }


                if (result == 1) {
                    call.respond(
                        HttpStatusCode.OK, ResponseCall(
                            success = true,
                            data = "Successfully updated car with licence plate: $licencePlate"
                        )
                    )
                } else {
                    call.respond(
                        HttpStatusCode.BadRequest,
                        ResponseCall(
                            success = false,
                            data = "Sorry could not update a car with licence plate: $licencePlate"
                        )
                    )
                }

            }
        }
    }
//}
