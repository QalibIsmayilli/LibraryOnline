package com.company.library.dto

import com.company.library.model.BookStatus

data class BookResponse private constructor(
    val id: String?,
    val title: String?,
    val authorName: String?,
    val bookStatus: BookStatus?,
    val publisher: String?,
    val lastPageNumber: Int?,
    val totalPage: Int?,
    val categoryId: String?,
    val imageUrl: String?
) {
    data class Builder(
        var id: String? = null,
        var title: String? = null,
        var authorName: String?= null,
        var bookStatus: BookStatus?= null,
        var publisher: String? = null,
        var lastPageNumber: Int? = null,
        var totalPage: Int? = null,
        var categoryId: String? = null,
        var imageUrl: String? = null) {

        fun id(id: String?) = apply { this.id = id }
        fun title(title: String?) = apply { this.title = title }
        fun authorName(authorName: String?) = apply { this.authorName = authorName }
        fun bookStatus(bookStatus: BookStatus?) = apply { this.bookStatus = bookStatus }
        fun publisher(publisher: String?) = apply { this.publisher = publisher }
        fun lastPageNumber(lastPageNumber: Int?) = apply { this.lastPageNumber = lastPageNumber }
        fun totalPage(totalPage: Int?) = apply { this.totalPage = totalPage }
        fun categoryId(categoryId: String?) = apply { this.categoryId = categoryId }
        fun imageUrl(imageUrl: String?=null) = apply { this.imageUrl = imageUrl }



        fun build() = BookResponse(id, title, authorName
            , bookStatus, publisher, lastPageNumber, totalPage, categoryId, imageUrl)
    }
}
