package com.company.library.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime


@Entity
@Table(name = "categories")
data class Category private constructor(

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

    @Column(name = "name")
    val name: String?,

    @OneToMany(mappedBy = "category", cascade = [CascadeType.ALL])
    @JsonIgnore
    val books: List<Book>?
){
    data class Builder(
        var id: String? = null,
        var createdDate: LocalDateTime?= null,
        var updateDate: LocalDateTime?= null,
        var name: String? = null,
        var books: List<Book>? = null) {

        fun id(id: String) = apply { this.id = id }
        fun createdDate(createdDate: LocalDateTime) = apply { this.createdDate = createdDate }
        fun updateDate(updateDate: LocalDateTime) = apply { this.updateDate = updateDate }
        fun name(name: String) = apply { this.name = name }
        fun books(books: List<Book>) = apply { this.books = books }

        fun build() = Category(id, createdDate, updateDate, name,books)
    }
}
