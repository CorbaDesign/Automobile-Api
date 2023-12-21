package com.example.automobile.data.database

import com.example.automobile.data.tables.Account
import com.example.automobile.data.tables.Car
import com.example.automobile.data.tables.UserProfile
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf

object DatabaseConnection {
    fun from(account: Account): Any {
        TODO("Not yet implemented")
    }

    val Database.accounts get() = this.sequenceOf(Account)
    val Database.userProfile get() = this.sequenceOf(UserProfile)
    val Database.car get() = this.sequenceOf(Car)


    val database = Database.connect(
        url = "jdbc:mysql://localhost:3306/automobile",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = ""
    )
}