package com.example.automobile.routing

import com.example.automobile.data.database.DatabaseConnection
import com.example.automobile.data.tables.CarLocation
import com.example.automobile.utils.types.ResponseCall
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import org.ktorm.dsl.*

@Serializable
data class CarLocationData(
    val id: Int,
    val postal: String,
    val longitude: String,
    val latitude: String
)

fun Application.carLocationRoutes(){
    val db = DatabaseConnection.database

    routing {
//        authenticate("auth-jwt"){

            // Get Carlocations
            get("/carlocations"){
                val locations = db.from(CarLocation).select()
                    .map {
                        val id = it[CarLocation.id]!!
                        val postal = it[CarLocation.postal]!!
                        val longitude =it[CarLocation.longitude]!!
                        val latitude = it[CarLocation.latitude]!!

                        CarLocationData(
                            id,
                            postal,
                            longitude,
                            latitude
                        )
                    }
                call.respond(locations)
            }

            post("/carlocation"){
                val myCarLocation = call.receive<CarLocationData>()
                val car = db.from(CarLocation)
                    .select()
                    .where(myCarLocation.id eq CarLocation.id)
                    .map { it[CarLocation.id] }
                    .firstOrNull()
                if (car != null){
                    call.respond(
                        HttpStatusCode.Conflict,
                        ResponseCall(
                            success = false,
                            data = "this car has allready registered a location"
                        )
                    )
                    return@post
                }
                val result = db.insert(CarLocation){
                    set(it.id, myCarLocation.id)
                    set(it.postal, myCarLocation.postal)
                    set(it.longitude, myCarLocation.longitude)
                    set(it.latitude, myCarLocation.latitude)
                }
                if (result == 1){
                    call.respond(
                        HttpStatusCode.OK,
                        ResponseCall(
                            success = true,
                            data = "Saved your carlocation succesfully"
                        )
                    )
                }else{
                    call.respond(
                        call.respond(
                            HttpStatusCode.BadRequest,
                            ResponseCall(
                                success = false,
                                data = "Sorry something went wrong"
                            )
                        )
                    )
                }
            }

            post("/carlocation/{postal&{id}"){
                val id = call.parameters["id"]?.toInt() ?: -1
                val postal = call.parameters["postal"] ?: null
            }

            
        }
    }
//}