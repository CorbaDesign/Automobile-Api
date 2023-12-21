package com.example.automobile.data.entities

import org.ktorm.entity.Entity

/*
 * The entity is a Kotlin object that is interacted with.
 */

interface AccountEntity : Entity<AccountEntity> {
    // A companion object allows you to immediately create an instance of the entity
    companion object : Entity.Factory<AccountEntity>()
    val id: Int
    var email: String
    var password: String
    var userProfileID: Int?
}