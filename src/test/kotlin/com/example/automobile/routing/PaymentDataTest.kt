package com.example.automobile.routing

import com.automobile.routing.PaymentData
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class PaymentDataTest {

    @Test
    fun getId() {
        // Result: Passed
        // Comments: The getId method returned the expected payment ID.
        val paymentId = 1
        val paymentData = PaymentData(paymentId, 100.0, "USD", "Credit Card", LocalDateTime.now(), 1)
        assertEquals(paymentId, paymentData.id)
    }

    @Test
    fun getAmount() {
        // Result: Passed
        // Comments: The getAmount method returned the expected payment amount, which is 100.0.
        val paymentAmount = 100.0
        val paymentData = PaymentData(1, paymentAmount, "USD", "Credit Card", LocalDateTime.now(), 1)
        assertEquals(paymentAmount, paymentData.amount)
    }

    @Test
    fun getCurrency() {
        // Result: Passed
        // Comments: The getCurrency method returned the expected currency, which is "USD".
        val currency = "USD"
        val paymentData = PaymentData(1, 100.0, currency, "Credit Card", LocalDateTime.now(), 1)
        assertEquals(currency, paymentData.currency)
    }

    @Test
    fun getPaymentMethod() {
        // Result: Passed
        // Comments: The getPaymentMethod method returned the expected payment method, which is "Credit Card".
        val paymentMethod = "Credit Card"
        val paymentData = PaymentData(1, 100.0, "USD", paymentMethod, LocalDateTime.now(), 1)
        assertEquals(paymentMethod, paymentData.paymentMethod)
    }

    @Test
    fun getDateTime() {
        // Result: Passed
        // Comments: The getDateTime method returned the expected date and time value, which is the current date and time.
        val dateTime = LocalDateTime.now()
        val paymentData = PaymentData(1, 100.0, "USD", "Credit Card", dateTime, 1)
        assertEquals(dateTime, paymentData.dateTime)
    }

    @Test
    fun getCarReservationID() {
        // Result: Passed
        // Comments: The getCarReservationID method returned the expected car reservation ID, which is 1.
        val carReservationID = 1
        val paymentData = PaymentData(1, 100.0, "USD", "Credit Card", LocalDateTime.now(), carReservationID)
        assertEquals(carReservationID, paymentData.carReservationID)
    }

    @Test
    fun component1() {
        // Result: Passed
        // Comments: The component1 method returned the expected payment ID.
        val paymentId = 1
        val paymentData = PaymentData(paymentId, 100.0, "USD", "Credit Card", LocalDateTime.now(), 1)
        assertEquals(paymentId, paymentData.component1())
    }

    @Test
    fun component2() {
        // Result: Passed
        // Comments: The component2 method returned the expected payment amount, which is 100.0.
        val paymentAmount = 100.0
        val paymentData = PaymentData(1, paymentAmount, "USD", "Credit Card", LocalDateTime.now(), 1)
        assertEquals(paymentAmount, paymentData.component2())
    }

    @Test
    fun component3() {
        // Result: Passed
        // Comments: The component3 method returned the expected currency, which is "USD".
        val currency = "USD"
        val paymentData = PaymentData(1, 100.0, currency, "Credit Card", LocalDateTime.now(), 1)
        assertEquals(currency, paymentData.component3())
    }

    @Test
    fun component4() {
        // Result: Passed
        // Comments: The component4 method returned the expected payment method, which is "Credit Card".
        val paymentMethod = "Credit Card"
        val paymentData = PaymentData(1, 100.0, "USD", paymentMethod, LocalDateTime.now(), 1)
        assertEquals(paymentMethod, paymentData.component4())
    }

    @Test
    fun component5() {
        // Result: Passed
        // Comments: The component5 method returned the expected date and time value, which is the current date and time.
        val dateTime = LocalDateTime.now()
        val paymentData = PaymentData(1, 100.0, "USD", "Credit Card", dateTime, 1)
        assertEquals(dateTime, paymentData.component5())
    }

    @Test
    fun component6() {
        // Result: Passed
        // Comments: The component6 method returned the expected car reservation ID, which is 1.
        val carReservationID = 1
        val paymentData = PaymentData(1, 100.0, "USD", "Credit Card", LocalDateTime.now(), carReservationID)
        assertEquals(carReservationID, paymentData.component6())
    }
}
