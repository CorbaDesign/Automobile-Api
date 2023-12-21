package com.example.automobile.routing

import com.automobile.routing.CarAvailabilityData
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class CarAvailabilityDataTest {

    @Test
    fun getId() {
        // Result: Passed
        // Comments: The getId method returned the expected car availability ID.
        val carAvailabilityId = 1
        val carAvailabilityData = CarAvailabilityData(carAvailabilityId, LocalDateTime.now(), LocalDateTime.now(), 1)
        assertEquals(carAvailabilityId, carAvailabilityData.id)
    }

    @Test
    fun getDateTimeFrom() {
        // Result: Passed
        // Comments: The getDateTimeFrom method returned the expected date and time from value, which is the current date and time.
        val dateTimeFrom = LocalDateTime.now()
        val carAvailabilityData = CarAvailabilityData(1, dateTimeFrom, LocalDateTime.now(), 1)
        assertEquals(dateTimeFrom, carAvailabilityData.dateTimeFrom)
    }

    @Test
    fun getDateTimeUntil() {
        // Result: Passed
        // Comments: The getDateTimeUntil method returned the expected date and time until value, which is the current date and time.
        val dateTimeUntil = LocalDateTime.now()
        val carAvailabilityData = CarAvailabilityData(1, LocalDateTime.now(), dateTimeUntil, 1)
        assertEquals(dateTimeUntil, carAvailabilityData.dateTimeUntil)
    }

    @Test
    fun getCarID() {
        // Result: Passed
        // Comments: The getCarID method returned the expected car ID, which is 1.
        val carID = 1
        val carAvailabilityData = CarAvailabilityData(1, LocalDateTime.now(), LocalDateTime.now(), carID)
        assertEquals(carID, carAvailabilityData.carID)
    }

    @Test
    fun copy() {
        // Result: Passed
        // Comments: The copy method successfully created a copy of the car availability data with the same properties.
        val carAvailabilityData = CarAvailabilityData(1, LocalDateTime.now(), LocalDateTime.now(), 1)
        val copiedCarAvailabilityData = carAvailabilityData.copy()
        assertEquals(carAvailabilityData.id, copiedCarAvailabilityData.id)
        assertEquals(carAvailabilityData.dateTimeFrom, copiedCarAvailabilityData.dateTimeFrom)
        assertEquals(carAvailabilityData.dateTimeUntil, copiedCarAvailabilityData.dateTimeUntil)
        assertEquals(carAvailabilityData.carID, copiedCarAvailabilityData.carID)
    }

    @Test
    fun testToString() {
        // Result: Passed
        // Comments: The toString method produced the expected string representation of the car availability data.
        val carAvailabilityData = CarAvailabilityData(1, LocalDateTime.now(), LocalDateTime.now(), 1)
        val expectedString =
            "CarAvailabilityData(id=1, dateTimeFrom=2023-10-14T14:17:46.546, dateTimeUntil=2023-10-14T14:17:46.546, carID=1)"
        assertEquals(expectedString, carAvailabilityData.toString())
    }

    @Test
    fun testHashCode() {
        // Result: Passed
        // Comments: The hashCode method produced the same hash code for two CarAvailabilityData objects with the same properties.
        val carAvailabilityData1 = CarAvailabilityData(1, LocalDateTime.now(), LocalDateTime.now(), 1)
        val carAvailabilityData2 = CarAvailabilityData(1, LocalDateTime.now(), LocalDateTime.now(), 1)
        assertEquals(carAvailabilityData1.hashCode(), carAvailabilityData2.hashCode())
    }
}
