package com.example.automobile.data.tables

import com.example.automobile.data.entities.PaymentEntity
import org.ktorm.schema.*

/*
 * The table is a translation of the SQL schema
 * By linking these together with the bind-to you can perform operations on an entity that are persisted in the database
 */

object Payment : org.ktorm.schema.Table<PaymentEntity>(tableName = "Payment") {
    val id = int(name = "paymentID").primaryKey().bindTo { it.id }
    val amount = double(name = "amount").bindTo { it.amount }
    val currency = varchar(name = "currency").bindTo { it.currency }
    val paymentMethod = varchar(name = "paymentMethod").bindTo { it.paymentMethod }
    val dateTime = datetime(name = "dateTime").bindTo { it.dateTime }
    val carReservationID = int(name = "carReservationID").bindTo { it.carReservationID }
}