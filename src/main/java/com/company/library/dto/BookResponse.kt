package com.company.library.dto

import com.company.library.model.BookStatus
import java.io.File

data class BookResponse(
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
    constructor(
        title: String?,
        authorName: String?,
        imageUrl: String?
    ) : this(
        id = "",
        title = title,
        authorName = authorName,
        bookStatus = null,
        publisher = "",
        lastPageNumber = 0,
        totalPage = 0,
        categoryId = "",
        imageUrl = imageUrl

    )
}
