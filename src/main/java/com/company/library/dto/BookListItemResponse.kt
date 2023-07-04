package com.company.library.dto

import com.company.library.model.BookStatus
import com.company.library.model.Category
import com.company.library.model.Image
import java.io.File
import java.time.LocalDateTime

data class BookListItemResponse(
    val id: String?,
    val title: String?,
    val authorName: String?,
    val bookStatus: BookStatus?,
    val publisher: String?,
    val lastPageNumber: Integer?,
    val totalPage: Integer?,
    val categoryName: String?,
    val imageFile: File?
){
    constructor(id:String?,
                title: String?,
                authorName: String?,
                bookStatus: BookStatus,
                publisher: String?,
                lastPageNumber: Integer?,
                totalPage: Integer?,
                categoryName: String?,
                 ):this(
        id = id, title = title, authorName = authorName, bookStatus = bookStatus,
        publisher = publisher, lastPageNumber = lastPageNumber,
        totalPage = totalPage , categoryName = categoryName, imageFile = null
                )
}
