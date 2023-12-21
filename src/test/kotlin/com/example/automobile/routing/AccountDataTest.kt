package com.example.automobile.routing

import org.junit.jupiter.api.Assertions.assertEquals

class AccountDataTest {

    @org.junit.jupiter.api.Test
    fun getId() {
        // Result: Passed
        // Comments: The getId method returned the expected result of 1 for the account's ID.
        val accountData = AccountResponseData(1, "test@example.com", 45)
        assertEquals(1, accountData.id)
    }

    @org.junit.jupiter.api.Test
    fun getEmail() {
        // Result: Passed
        // Comments: The getEmail method returned the expected email address "test@example.com".
        val accountData = AccountResponseData(1, "test@example.com", 45)
        assertEquals("test@example.com", accountData.email)
    }

    @org.junit.jupiter.api.Test
    fun getUserProfileID() {
        // Result: Passed
        // Comments: The getUserProfileID method returned the expected user profile ID of 45.
        val accountData = AccountResponseData(1, "test@example.com", 45)
        assertEquals(45, accountData.userProfileID)
    }
}
