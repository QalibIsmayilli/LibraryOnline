package com.company.library.dto

data class TokenResponse(
    val accessToken: String?,
    val userDto: UserDto?
)
