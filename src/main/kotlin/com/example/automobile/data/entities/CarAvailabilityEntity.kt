package com.example.automobile.data.entities

import org.ktorm.entity.Entity
import java.time.LocalDateTime

/*
 * The entity is a Kotlin object that is interacted with.
 */

interface CarAvailabilityEntity : Entity<CarAvailabilityEntity> {
    // A companion object allows you to immediately create an instance of the entity
    companion object : Entity.Factory<CarAvailabilityEntity>()
    val id: Int
    var dateTimeFrom: LocalDateTime
    var dateTimeUntil: LocalDateTime
    var carID: Int
}