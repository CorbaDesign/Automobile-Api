package com.example.automobile.data.tables

import com.example.automobile.data.entities.CarAvailabilityEntity
import org.ktorm.schema.datetime
import org.ktorm.schema.int

/*
 * The table is a translation of the SQL schema
 * By linking these together with the bind-to you can perform operations on an entity that are persisted in the database
 */

object CarAvailability : org.ktorm.schema.Table<CarAvailabilityEntity>(tableName = "CarAvailability") {
    val id = int(name = "carAvailabilityID").primaryKey().bindTo { it.id }
    val dateTimeFrom = datetime(name = "dateTimefrom").bindTo { it.dateTimeFrom }
    val dateTimeUntil = datetime(name = "dateTimeUntil").bindTo { it.dateTimeUntil }
    val carID = int(name = "carID").bindTo { it.carID }
}