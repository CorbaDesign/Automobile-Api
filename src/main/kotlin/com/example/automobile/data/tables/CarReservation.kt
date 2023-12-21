package com.example.automobile.data.tables

import com.example.automobile.data.entities.CarReservationEntity
import org.ktorm.schema.datetime
import org.ktorm.schema.int

/*
 * The table is a translation of the SQL schema
 * By linking these together with the bind-to you can perform operations on an entity that are persisted in the database
 */

object CarReservation : org.ktorm.schema.Table<CarReservationEntity>(tableName = "CarReservation") {
    val id = int(name = "carReservationID").primaryKey().bindTo { it.id }
    val dateTimeFrom = datetime(name = "dateTimeFrom").bindTo { it.dateTimeFrom }
    val dateTimeUntil = datetime(name = "dateTimeUntil").bindTo { it.dateTimeUntil }
    val userProfileID = int(name = "userProfileID").bindTo { it.userProfileID }
    val carID = int(name = "carID").bindTo { it.carID }
}