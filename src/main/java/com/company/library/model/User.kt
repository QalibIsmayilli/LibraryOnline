package com.company.library.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "users")
data class User(

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String?,

    @Column(name = "created_date")
    @CreationTimestamp
    val createdDate: LocalDateTime?,

    @Column(name = "update_date")
    @UpdateTimestamp
    val updateDate: LocalDateTime?,

    @Column(name = "username", unique = true)
    val username: String?,

    @Column(name = "password")
    val password: String?,

    @Column(name = "email")
    val email: String?,

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    val role: Role?

) {


    data class Builder(
        var id: String? = null,
        var createdDate: LocalDateTime? = null,
        var updateDate: LocalDateTime? = null,
        var username: String? = null,
        var password: String? = null,
        var email: String? = null,
        var role: Role? = null
    ) {

        fun id(id: String?) = apply { this.id = id }
        fun createdDate(createdDate: LocalDateTime?) = apply { this.createdDate = createdDate }
        fun updateDate(updateDate: LocalDateTime?) = apply { this.updateDate = updateDate }
        fun username(title: String?) = apply { this.username = username }
        fun password(password: String?) = apply { this.password = password }
        fun email(email: String?) = apply { this.email = email }
        fun role(role: Role?) = apply { this.role = role }


        fun build() = User(id, createdDate, updateDate, username, password, email, role)

    }
}
