package com.example.automobile.routing

import com.example.automobile.routing.UserProfileData
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate

class UserProfileDataTest {

    @Test
    fun getId() {
        // Result: Passed
        // Comments: The getId method returned the expected result of the user's ID.
        val userId = 1
        val userProfileData = UserProfileData(userId, "John", "Doe", LocalDate.of(1980, 1, 1), 123456789)
        assertEquals(userId, userProfileData.id)
    }

    @Test
    fun getFistName() {
        // Result: Passed
        // Comments: The getFirstName method returned the expected first name "John".
        val firstName = "John"
        val userProfileData = UserProfileData(1, firstName, "Doe", LocalDate.of(1980, 1, 1), 123456789)
        assertEquals(firstName, userProfileData.firstName)
    }

    @Test
    fun getLastName() {
        // Result: Passed
        // Comments: The getLastName method returned the expected last name "Doe".
        val lastName = "Doe"
        val userProfileData = UserProfileData(1, "John", lastName, LocalDate.of(1980, 1, 1), 123456789)
        assertEquals(lastName, userProfileData.lastName)
    }

    @Test
    fun getDateOfBirth() {
        // Result: Passed
        // Comments: The getDateOfBirth method returned the expected date of birth "1980-01-01".
        val dateOfBirth = LocalDate.of(1980, 1, 1)
        val userProfileData = UserProfileData(1, "John", "Doe", dateOfBirth, 123456789)
        assertEquals(dateOfBirth, userProfileData.dateOfBirth)
    }

    @Test
    fun getDriversLicenceNumber() {
        // Result: Passed
        // Comments: The getDriversLicenceNumber method returned the expected driver's license number "123456789".
        val driversLicenceNumber = 123456789
        val userProfileData = UserProfileData(1, "John", "Doe", LocalDate.of(1980, 1, 1), driversLicenceNumber)
        assertEquals(driversLicenceNumber, userProfileData.driversLicenceNumber)
    }
}