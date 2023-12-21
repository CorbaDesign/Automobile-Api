package com.example.automobile.utils.types

import kotlinx.serialization.Serializable

@Serializable
data class ResponseCall<T>(
    val success: Boolean,
    val data: T
)
