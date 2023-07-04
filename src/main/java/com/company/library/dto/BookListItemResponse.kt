package com.company.library.dto

import com.company.library.model.BookStatus
import java.io.File

data class BookListItemResponse private constructor(
    val id: String?,
    val title: String?,
    val authorName: String?,
    val bookStatus: BookStatus?,
    val publisher: String?,
    val lastPageNumber: Int?,
    val totalPage: Int?,
    val categoryName: String?,
    val imageFile: File?
){

    data class Builder(
        var id: String? = null,
        var title: String? = null,
        var authorName: String?= null,
        var bookStatus: BookStatus?= null,
        var publisher: String? = null,
        var lastPageNumber: Int? = null,
        var totalPage: Int? = null,
        var categoryName: String? = null,
        var imageFile: File? = null) {

        fun id(id: String) = apply { this.id = id }
        fun title(title: String) = apply { this.title = title }
        fun authorName(authorName: String) = apply { this.authorName = authorName }
        fun bookStatus(bookStatus: BookStatus) = apply { this.bookStatus = bookStatus }
        fun publisher(publisher: String) = apply { this.publisher = publisher }
        fun lastPageNumber(lastPageNumber: Int) = apply { this.lastPageNumber = lastPageNumber }
        fun totalPage(totalPage: Int) = apply { this.totalPage = totalPage }
        fun categoryName(categoryName: String) = apply { this.categoryName = categoryName }
        fun imageFile(imageFile: File) = apply { this.imageFile = imageFile }



        fun build() = BookListItemResponse(id, title, authorName
            , bookStatus, publisher, lastPageNumber, totalPage, categoryName, imageFile)
    }
}
