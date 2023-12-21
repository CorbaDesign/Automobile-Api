package com.example.automobile.data.entities

import org.ktorm.entity.Entity
import java.time.LocalDateTime

interface PaymentEntity : Entity<PaymentEntity> {
    // A companion object allows you to immediately create an instance of the entity
    companion object : Entity.Factory<PaymentEntity>()
    val id: Int
    var amount: Double
    var currency: String
    var paymentMethod: String
    var dateTime: LocalDateTime
    var carReservationID: Int
}