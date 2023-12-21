package com.example.automobile.data.tables

import com.example.automobile.data.entities.CarLocationEnity
import org.ktorm.schema.datetime
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object CarLocation : org.ktorm.schema.Table<CarLocationEnity>(tableName = "CarLocation"){
    val id = int(name ="carID").primaryKey().bindTo { it.id }
    val postal = varchar(name = "postal").bindTo { it.postal }
    val longitude = varchar(name = "longitude").bindTo { it.longitude }
    val latitude = varchar(name = "latitude").bindTo { it.latitude }
}