package com.company.library.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "books")
data class Book(

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

    @Column(name = "title")
    val title: String?,

    @Column(name = "author_name")
    val authorName: String?,

    @Column(name = "book_status")
    @Enumerated(value = EnumType.STRING)
    val bookStatus: BookStatus?,

    @Column(name = "publisher")
    val publisher: String?,

    @Column(name = "last_page_number")
    val lastPageNumber: Int?,

    @Column(name = "total_page")
    val totalPage: Int?,

    @Column(name = "category")
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "category")
    val category: Category?,

    @OneToOne
    @JoinColumn(name = "image")
    val image: Image?,


    val userId: String?

) {
    constructor(
        title: String?,
        authorName: String?,
        bookStatus: BookStatus,
        publisher: String?,
        lastPageNumber: Int?,
        totalPage: Int?,
        category: Category?,
        image: Image?
    ) : this(
        id = "", createdDate = LocalDateTime.now(), updateDate = LocalDateTime.now(),
        title = title, authorName = authorName, bookStatus = bookStatus,
        publisher = publisher, lastPageNumber = lastPageNumber,
        totalPage = totalPage , category = category, image = image,userId = ""
        )

    constructor(
        title: String?,
        authorName: String?,
        bookStatus: BookStatus,
        publisher: String?,
        lastPageNumber: Int?,
        totalPage: Int?,
        category: Category?,
        ) : this(
        id = "", createdDate = LocalDateTime.now(), updateDate = LocalDateTime.now(),
        title = title, authorName = authorName, bookStatus = bookStatus,
        publisher = publisher, lastPageNumber = lastPageNumber,
        totalPage = totalPage , category = category, image = null, userId = ""
    )


}


