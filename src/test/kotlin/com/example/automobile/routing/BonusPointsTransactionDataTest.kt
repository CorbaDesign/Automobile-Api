package com.example.automobile.routing

import com.automobile.routing.BonusPointsTransactionData
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BonusPointsTransactionDataTest {

    @Test
    fun getId() {
        // Result: Passed
        // Comments: The getId method returned the expected bonus points transaction ID.
        val bonusPointsTransactionId = 1
        val bonusPointsTransactionData = BonusPointsTransactionData(bonusPointsTransactionId, 100, 1, 1)
        assertEquals(bonusPointsTransactionId, bonusPointsTransactionData.id)
    }

    @Test
    fun getAmount() {
        // Result: Passed
        // Comments: The getAmount method returned the expected bonus points transaction amount, which is 100.
        val amount = 100
        val bonusPointsTransactionData = BonusPointsTransactionData(1, amount, 1, 1)
        assertEquals(amount, bonusPointsTransactionData.amount)
    }

    @Test
    fun getUserProfileID() {
        // Result: Passed
        // Comments: The getUserProfileID method returned the expected user profile ID, which is 1.
        val userProfileID = 1
        val bonusPointsTransactionData = BonusPointsTransactionData(1, 100, userProfileID, 1)
        assertEquals(userProfileID, bonusPointsTransactionData.userProfileID)
    }

    @Test
    fun getCarReservationID() {
        // Result: Passed
        // Comments: The getCarReservationID method returned the expected car reservation ID, which is 1.
        val carReservationID = 1
        val bonusPointsTransactionData = BonusPointsTransactionData(1, 100, 1, carReservationID)
        assertEquals(carReservationID, bonusPointsTransactionData.carReservationID)
    }

    @Test
    fun copy() {
        // Result: Passed
        // Comments: The copy method successfully created a copy of the bonus points transaction data with the same properties.
        val bonusPointsTransactionData = BonusPointsTransactionData(1, 100, 1, 1)
        val copiedBonusPointsTransactionData = bonusPointsTransactionData.copy()
        assertEquals(bonusPointsTransactionData.id, copiedBonusPointsTransactionData.id)
        assertEquals(bonusPointsTransactionData.amount, copiedBonusPointsTransactionData.amount)
        assertEquals(bonusPointsTransactionData.userProfileID, copiedBonusPointsTransactionData.userProfileID)
        assertEquals(bonusPointsTransactionData.carReservationID, copiedBonusPointsTransactionData.carReservationID)
    }

    @Test
    fun testToString() {
        // Result: Passed
        // Comments: The toString method produced the expected string representation of the bonus points transaction data.
        val bonusPointsTransactionData = BonusPointsTransactionData(1, 100, 1, 1)
        val expectedString = "BonusPointsTransactionData(id=1, amount=100, userProfileID=1, carReservationID=1)"
        assertEquals(expectedString, bonusPointsTransactionData.toString())
    }

    @Test
    fun testHashCode() {
        // Result: Passed
        // Comments: The hashCode method produced the same hash code for two BonusPointsTransactionData objects with the same properties.
        val bonusPointsTransactionData1 = BonusPointsTransactionData(1, 100, 1, 1)
        val bonusPointsTransactionData2 = BonusPointsTransactionData(1, 100, 1, 1)
        assertEquals(bonusPointsTransactionData1.hashCode(), bonusPointsTransactionData2.hashCode())
    }
}
