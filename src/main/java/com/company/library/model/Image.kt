package com.company.library.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "images")
data class Image private constructor(
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

    @Column(name = "image_url")
    val imageUrl : String?
){

    data class Builder(
        var id: String? = null,
        var createdDate: LocalDateTime?= null,
        var updateDate: LocalDateTime?= null,
        var imageUrl: String? = null) {

        fun id(id: String) = apply { this.id = id }
        fun createdDate(createdDate: LocalDateTime) = apply { this.createdDate = createdDate }
        fun updateDate(updateDate: LocalDateTime) = apply { this.updateDate = updateDate }
        fun imageUrl(imageUrl: String) = apply { this.imageUrl = imageUrl }

        fun build() = Image(id, createdDate, updateDate, imageUrl)
    }
}