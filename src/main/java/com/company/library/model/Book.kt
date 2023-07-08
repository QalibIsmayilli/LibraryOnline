package com.company.library.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "books")
data class Book private constructor(

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
    @Enumerated(EnumType.STRING)
    val bookStatus: BookStatus?,

    @Column(name = "publisher")
    val publisher: String?,

    @Column(name = "last_page_number")
    val lastPageNumber: Int?,

    @Column(name = "total_page")
    val totalPage: Int?,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "category")
    val category: Category?,

    @OneToOne
    @JoinColumn(name = "image")
    val image: Image?,


    val userId: String?

) {

    data class Builder(
        var id: String? = null,
        var createdDate: LocalDateTime?= null,
        var updateDate: LocalDateTime?= null,
        var title: String? = null,
        var authorName: String?= null,
        var bookStatus: BookStatus?= null,
        var publisher: String? = null,
        var lastPageNumber: Int? = null,
        var totalPage: Int? = null,
        var category: Category? = null,
        var image: Image? = null,
        var userId: String? = null ) {

        fun id(id: String?) = apply { this.id = id }
        fun createdDate(createdDate: LocalDateTime?) = apply { this.createdDate = createdDate }
        fun updateDate(updateDate: LocalDateTime?) = apply { this.updateDate = updateDate }
        fun title(title: String?) = apply { this.title = title }
        fun authorName(authorName: String?) = apply { this.authorName = authorName }
        fun bookStatus(bookStatus: BookStatus?) = apply { this.bookStatus = bookStatus }
        fun publisher(publisher: String?) = apply { this.publisher = publisher }
        fun lastPageNumber(lastPageNumber: Int?) = apply { this.lastPageNumber = lastPageNumber }
        fun totalPage(totalPage: Int?) = apply { this.totalPage = totalPage }
        fun category(category: Category?) = apply { this.category = category }
        fun image(image: Image?) = apply { this.image = image }
        fun userId(userId: String?) = apply { this.userId = userId }


        fun build() = Book(id, createdDate, updateDate, title, authorName
            , bookStatus, publisher, lastPageNumber, totalPage, category, image, userId)

    }


}


