package com.example.automobile.data.entities

import org.ktorm.entity.Entity

/*
 * The entity is a Kotlin object that is interacted with.
 */

interface CarEntity : Entity<CarEntity> {
    // A companion object allows you to immediately create an instance of the entity
    companion object : Entity.Factory<CarEntity>()
    val id: Int
    var licencePlate: String
    var carBrand: String
    var vehicleType: String
    var amountOfPassengers: Int
    var amountOfDoors: Int
    var automatic: Boolean
    var gpsAvailable: Boolean
    var carPriceAmount: Double
    var carPriceCurrency: String
    var userProfileID: Int
}