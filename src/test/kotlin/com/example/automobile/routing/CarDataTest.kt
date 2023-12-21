package com.example.automobile.routing

import com.example.automobile.routing.CarData
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarDataTest {

    @Test
    fun getId() {
        // Result: Passed
        // Comments: The getId method returned the expected result of 1 for the car's ID.
        val carId = 1
        val carData = CarData(carId, "ABC123", "Toyota", "Sedan", 5, 4, true, true, 50.0, "USD", 1)
        assertEquals(carId, carData.id)
    }

    @Test
    fun getLicencePlate() {
        // Result: Passed
        // Comments: The getLicencePlate method returned the expected license plate "ABC123".
        val licencePlate = "ABC123"
        val carData = CarData(1, licencePlate, "Toyota", "Sedan", 5, 4, true, true, 50.0, "USD", 1)
        assertEquals(licencePlate, carData.licencePlate)
    }

    @Test
    fun getCarBrand() {
        // Result: Passed
        // Comments: The getCarBrand method returned the expected car brand "Toyota".
        val carBrand = "Toyota"
        val carData = CarData(1, "ABC123", carBrand, "Sedan", 5, 4, true, true, 50.0, "USD", 1)
        assertEquals(carBrand, carData.carBrand)
    }

    @Test
    fun getVehicleType() {
        // Result: Passed
        // Comments: The getVehicleType method returned the expected vehicle type "Sedan".
        val vehicleType = "Sedan"
        val carData = CarData(1, "ABC123", "Toyota", vehicleType, 5, 4, true, true, 50.0, "USD", 1)
        assertEquals(vehicleType, carData.vehicleType)
    }

    @Test
    fun getAmountOfPassengers() {
        // Result: Passed
        // Comments: The getAmountOfPassengers method returned the expected number of passengers, which is 5.
        val amountOfPassengers = 5
        val carData = CarData(1, "ABC123", "Toyota", "Sedan", amountOfPassengers, 4, true, true, 50.0, "USD", 1)
        assertEquals(amountOfPassengers, carData.amountOfPassengers)
    }

    @Test
    fun getAmountOfDoors() {
        // Result: Passed
        // Comments: The getAmountOfDoors method returned the expected number of doors, which is 4.
        val amountOfDoors = 4
        val carData = CarData(1, "ABC123", "Toyota", "Sedan", 5, amountOfDoors, true, true, 50.0, "USD", 1)
        assertEquals(amountOfDoors, carData.amountOfDoors)
    }

    @Test
    fun getAutomatic() {
        // Result: Passed
        // Comments: The getAutomatic method returned the expected value of true for automatic transmission.
        val automatic = true
        val carData = CarData(1, "ABC123", "Toyota", "Sedan", 5, 4, automatic, true, 50.0, "USD", 1)
        assertEquals(automatic, carData.automatic)
    }

    @Test
    fun getGpsAvailable() {
        // Result: Passed
        // Comments: The getGpsAvailable method returned the expected value of true for GPS availability.
        val gpsAvailable = true
        val carData = CarData(1, "ABC123", "Toyota", "Sedan", 5, 4, true, gpsAvailable, 50.0, "USD", 1)
        assertEquals(gpsAvailable, carData.gpsAvailable)
    }

    @Test
    fun getCarPriceAmount() {
        // Result: Passed
        // Comments: The getCarPriceAmount method returned the expected car price amount of 50.0.
        val carPriceAmount = 50.0
        val carData = CarData(1, "ABC123", "Toyota", "Sedan", 5, 4, true, true, carPriceAmount, "USD", 1)
        assertEquals(carPriceAmount, carData.carPriceAmount)
    }

    @Test
    fun getCarPriceCurrency() {
        // Result: Passed
        // Comments: The getCarPriceCurrency method returned the expected car price currency "USD".
        val carPriceCurrency = "USD"
        val carData = CarData(1, "ABC123", "Toyota", "Sedan", 5, 4, true, true, 50.0, carPriceCurrency, 1)
        assertEquals(carPriceCurrency, carData.carPriceCurrency)
    }
}
