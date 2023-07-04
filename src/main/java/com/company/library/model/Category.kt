package com.company.library.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime


@Entity
@Table(name = "categories")
data class Category(

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
)
