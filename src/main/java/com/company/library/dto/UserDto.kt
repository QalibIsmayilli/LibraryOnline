package com.company.library.dto

import com.company.library.model.Role

data class UserDto(
    val username: String?,
    val email: String?,
    val role: Role?
)
