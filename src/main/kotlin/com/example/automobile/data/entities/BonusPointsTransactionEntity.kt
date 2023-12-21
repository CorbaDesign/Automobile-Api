package com.example.automobile.data.entities

import org.ktorm.entity.Entity

/*
 * The entity is a Kotlin object that is interacted with.
 */

interface BonusPointsTransactionEntity : Entity<BonusPointsTransactionEntity> {
    // A companion object allows you to immediately create an instance of the entity
    val id: Int
    val amount: Int
    val userProfileID: Int
    val carReservationID: Int
}