package com.example.automobile.data.entities

import org.ktorm.entity.Entity
import java.time.LocalDate

/*
 * The entity is a Kotlin object that is interacted with.
 */

interface UserProfileEntity : Entity<UserProfileEntity> {
    // A companion object allows you to immediately create an instance of the entity
    companion object : Entity.Factory<UserProfileEntity>()
    val id: Int
    val firstName: String
    val lastName: String
    val dateOfBirth: LocalDate
    val driversLicenceNumber: Int
}