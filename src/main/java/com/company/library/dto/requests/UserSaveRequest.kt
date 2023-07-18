package com.company.library.dto.requests

import com.company.library.model.Role
import com.company.library.model.User
import java.time.LocalDateTime

data class UserSaveRequest(
    val username: String?,
    val password: String?,
    val email: String?,
    val role: Role?
) {
    data class Builder(
        var username: String? = null,
        var password: String? = null,
        var email: String? = null,
        var role: Role? = null
    ) {

        fun username(username: String?) = apply { this.username = username }
        fun password(password: String?) = apply { this.password = password }
        fun email(email: String?) = apply { this.email = email }
        fun role(role: Role?) = apply { this.role = role }


        fun build() = UserSaveRequest(username, password, email, role)
    }
}
