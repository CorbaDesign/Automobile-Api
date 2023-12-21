package com.example.automobile.data.entities

import org.ktorm.entity.Entity

interface CarLocationEnity : Entity<CarLocationEnity> {
    companion object : Entity.Factory<CarLocationEnity>()
    val id: Int
    var postal: String
    var longitude: String
    var latitude: String
}