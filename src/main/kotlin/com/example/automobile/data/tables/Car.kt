package com.example.automobile.data.tables

import com.example.automobile.data.entities.CarEntity
import org.ktorm.schema.boolean
import org.ktorm.schema.double
import org.ktorm.schema.int
import org.ktorm.schema.varchar

/*
 * The table is a translation of the SQL schema
 * By linking these together with the bind-to you can perform operations on an entity that are persisted in the database
 */

object Car : org.ktorm.schema.Table<CarEntity>(tableName = "Car") {
    val id = int(name = "carID").primaryKey().bindTo { it.id }
    val licencePlate = varchar(name = "licencePlate").bindTo { it.licencePlate }
    val carBrand = varchar(name = "carBrand").bindTo { it.carBrand }
    val vehicleType = varchar(name = "vehicleType").bindTo { it.vehicleType }
    val amountOfPassengers = int(name = "amountOfPassengers").bindTo { it.amountOfPassengers }
    val amountOfDoors = int(name = "amountOfDoors").bindTo { it.amountOfDoors }
    val automatic = boolean(name = "automatic").bindTo { it.automatic }
    val gpsAvailable = boolean(name = "gpsAvailable").bindTo { it.gpsAvailable }
    val carPriceAmount = double(name = "carPriceAmount").bindTo { it.carPriceAmount }
    val carPriceCurrency = varchar(name = "carPriceCurrency").bindTo { it.carPriceCurrency }
    val userProfileID = int(name = "userProfileID").bindTo { it.userProfileID }
}