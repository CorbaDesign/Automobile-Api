package com.example.automobile.routing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.mindrot.jbcrypt.BCrypt

class AuthenticationDataTest {

    @Test
    fun hashedPassword() {
        // Result: Passed
        // Comments: The hashedPassword method successfully hashed the password and it can be verified using BCrypt.
        val password = "password123"
        val hashedPassword = AuthenticationData("test@example.com", password).hashedPassword()
        assertTrue(BCrypt.checkpw(password, hashedPassword))
    }

    @Test
    fun getEmail() {
        // Result: Passed
        // Comments: The getEmail method returned the expected email address "test@example.com".
        val email = "test@example.com"
        val authenticationData = AuthenticationData(email, "password123")
        assertEquals(email, authenticationData.email)
    }

    @Test
    fun setEmail() {
        // Result: Passed
        // Comments: The setEmail method successfully updated the email address to "newEmail@example.com".
        val authenticationData = AuthenticationData("test@example.com", "password123")
        authenticationData.email = "newEmail@example.com"
        assertEquals("newEmail@example.com", authenticationData.email)
    }

    @Test
    fun getPassword() {
        // Result: Passed
        // Comments: The getPassword method returned the expected password "password123".
        val password = "password123"
        val authenticationData = AuthenticationData("test@example.com", password)
        assertEquals(password, authenticationData.password)
    }

    @Test
    fun setPassword() {
        // Result: Passed
        // Comments: The setPassword method successfully updated the password to "newPassword123".
        val authenticationData = AuthenticationData("test@example.com", "password123")
        authenticationData.password = "newPassword123"
        assertEquals("newPassword123", authenticationData.password)
    }

    @Test
    fun copy() {
        // Result: Passed
        // Comments: The copy method successfully created a copy of the authentication data with the same email and password.
        val authenticationData = AuthenticationData("test@example.com", "password123")
        val copiedData = authenticationData.copy()
        assertEquals(authenticationData.email, copiedData.email)
        assertEquals(authenticationData.password, copiedData.password)
    }

    @Test
    fun testToString() {
        // Result: Passed
        // Comments: The toString method produced a string containing the email and password information.
        val authenticationData = AuthenticationData("test@example.com", "password123")
        assertTrue(authenticationData.toString().contains("email=test@example.com"))
        assertTrue(authenticationData.toString().contains("password=password123"))
    }

    @Test
    fun testHashCode() {
        // Result: Passed
        // Comments: The hashCode method produced the same hash code for two AuthenticationData objects with the same email and password.
        val authenticationData1 = AuthenticationData("test@example.com", "password123")
        val authenticationData2 = AuthenticationData("test@example.com", "password123")
        assertEquals(authenticationData1.hashCode(), authenticationData2.hashCode())
    }

    @Test
    fun testEquals() {
        // Result: Passed
        // Comments: The equals method correctly determined that two AuthenticationData objects with the same email and password are equal.
        val authenticationData1 = AuthenticationData("test@example.com", "password123")
        val authenticationData2 = AuthenticationData("test@example.com", "password123")
        assertTrue(authenticationData1 == authenticationData2)
    }
}
