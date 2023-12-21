package com.example.automobile.data.tables

import com.example.automobile.data.entities.BonusPointsTransactionEntity
import org.ktorm.schema.int

/*
 * The table is a translation of the SQL schema
 * By linking these together with the bind-to you can perform operations on an entity that are persisted in the database
 */

object BonusPointsTransaction : org.ktorm.schema.Table<BonusPointsTransactionEntity>(tableName = "BonusPointsTransaction"){
    val id                  = int(name = "bonusPointsTransactionID").primaryKey().bindTo { it.id }
    val amount              = int(name = "amount").bindTo { it.amount}
    val userProfileID       = int(name = "userProfileID").bindTo { it.userProfileID }
    val carReservationID    = int(name = "carReservationID").bindTo { it.carReservationID }

}