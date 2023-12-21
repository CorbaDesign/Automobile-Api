package com.example.automobile.data.tables

import com.example.automobile.data.entities.AccountEntity
import org.ktorm.schema.int
import org.ktorm.schema.varchar

/*
 * The table is a translation of the SQL schema
 * By linking these together with the bind-to you can perform operations on an entity that are persisted in the database
 */

object Account : org.ktorm.schema.Table<AccountEntity>(tableName = "Account") {
    val id              = int(name = "accountID").primaryKey().bindTo { it.id }
    val email           = varchar(name = "email").bindTo { it.email }
    val password        = varchar(name = "password").bindTo { it.password }
    val userProfileID   = int(name = "userProfileID").bindTo { it.userProfileID }
}