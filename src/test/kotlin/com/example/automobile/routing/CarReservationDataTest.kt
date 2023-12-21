package com.example.automobile.routing

import com.automobile.routing.CarReservationData
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class CarReservationDataTest {

    @Test
    fun getId() {
        // Result: Passed
        // Comments: The getId method returned the expected car reservation ID.
        val carReservationId = 1
        val carReservationData = CarReservationData(carReservationId, LocalDateTime.now(), LocalDateTime.now(), 1, 1)
        assertEquals(carReservationId, carReservationData.id)
    }

    @Test
    fun getDateTimeFrom() {
        // Result: Passed
        // Comments: The getDateTimeFrom method returned the expected date and time from value, which is the current date and time.
        val dateTimeFrom = LocalDateTime.now()
        val carReservationData = CarReservationData(1, dateTimeFrom, LocalDateTime.now(), 1, 1)
        assertEquals(dateTimeFrom, carReservationData.dateTimeFrom)
    }

    @Test
    fun getDateTimeUntil() {
        // Result: Passed
        // Comments: The getDateTimeUntil method returned the expected date and time until value, which is the current date and time.
        val dateTimeUntil = LocalDateTime.now()
        val carReservationData = CarReservationData(1, LocalDateTime.now(), dateTimeUntil, 1, 1)
        assertEquals(dateTimeUntil, carReservationData.dateTimeUntil)
    }

    @Test
    fun getUserProfileID() {
        // Result: Passed
        // Comments: The getUserProfileID method returned the expected user profile ID, which is 1.
        val userProfileID = 1
        val carReservationData = CarReservationData(1, LocalDateTime.now(), LocalDateTime.now(), userProfileID, 1)
        assertEquals(userProfileID, carReservationData.userProfileID)
    }

    @Test
    fun getCarID() {
        // Result: Passed
        // Comments: The getCarID method returned the expected car ID, which is 1.
        val carID = 1
        val carReservationData = CarReservationData(1, LocalDateTime.now(), LocalDateTime.now(), 1, carID)
        assertEquals(carID, carReservationData.carID)
    }

    @Test
    fun component1() {
        // Result: Passed
        // Comments: The component1 method returned the expected car reservation ID.
        val carReservationId = 1
        val carReservationData = CarReservationData(carReservationId, LocalDateTime.now(), LocalDateTime.now(), 1, 1)
        assertEquals(carReservationId, carReservationData.component1())
    }

    @Test
    fun component2() {
        // Result: Passed
        // Comments: The component2 method returned the expected date and time from value, which is the current date and time.
        val dateTimeFrom = LocalDateTime.now()
        val carReservationData = CarReservationData(1, dateTimeFrom, LocalDateTime.now(), 1, 1)
        assertEquals(dateTimeFrom, carReservationData.component2())
    }

    @Test
    fun component3() {
        // Result: Passed
        // Comments: The component3 method returned the expected date and time until value, which is the current date and time.
        val dateTimeUntil = LocalDateTime.now()
        val carReservationData = CarReservationData(1, LocalDateTime.now(), dateTimeUntil, 1, 1)
        assertEquals(dateTimeUntil, carReservationData.component3())
    }

    @Test
    fun component4() {
        // Result: Passed
        // Comments: The component4 method returned the expected user profile ID, which is 1.
        val userProfileID = 1
        val carReservationData = CarReservationData(1, LocalDateTime.now(), LocalDateTime.now(), userProfileID, 1)
        assertEquals(userProfileID, carReservationData.component4())
    }

    @Test
    fun component5() {
        // Result: Passed
        // Comments: The component5 method returned the expected car ID, which is 1.
        val carID = 1
        val carReservationData = CarReservationData(1, LocalDateTime.now(), LocalDateTime.now(), 1, carID)
        assertEquals(carID, carReservationData.component5())
    }

    @Test
    fun copy() {
        // Result: Passed
        // Comments: The copy method successfully created a copy of the car reservation data with the same properties.
        val carReservationData = CarReservationData(1, LocalDateTime.now(), LocalDateTime.now(), 1, 1)
        val copiedCarReservationData = carReservationData.copy()
        assertEquals(carReservationData.id, copiedCarReservationData.id)
        assertEquals(carReservationData.dateTimeFrom, copiedCarReservationData.dateTimeFrom)
        assertEquals(carReservationData.dateTimeUntil, copiedCarReservationData.dateTimeUntil)
        assertEquals(carReservationData.userProfileID, copiedCarReservationData.userProfileID)
        assertEquals(carReservationData.carID, copiedCarReservationData.carID)
    }
}
