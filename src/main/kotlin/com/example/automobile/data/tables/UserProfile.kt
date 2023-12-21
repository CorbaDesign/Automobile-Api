package com.example.automobile.data.tables

import com.example.automobile.data.entities.UserProfileEntity
import org.ktorm.schema.date
import org.ktorm.schema.int
import org.ktorm.schema.varchar

/*
 * The table is a translation of the SQL schema
 * By linking these together with the bind-to you can perform operations on an entity that are persisted in the database
 */

object UserProfile : org.ktorm.schema.Table<UserProfileEntity>(tableName = "UserProfile") {
    val id                      = int(name = "userProfileID").primaryKey().bindTo { it.id }
    val firstName               = varchar(name = "firstName").bindTo { it.firstName }
    val lastName                = varchar(name = "lastName").bindTo { it.lastName }
    val dateOfBirth             = date(name = "dateOfBirth").bindTo { it.dateOfBirth }
    val driversLicenceNumber    = int(name = "driversLicenceNumber").bindTo { it.driversLicenceNumber }
}