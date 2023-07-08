package com.company.library.dto.requests

import com.company.library.model.BookStatus
import com.fasterxml.jackson.annotation.JsonCreator
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.io.File

data class BookSaveRequest(

    @field:NotBlank
    val title: String?,
    @field:NotBlank
    val authorName: String?,
    @field:NotNull
    val bookStatus: BookStatus?,
    @field:NotBlank
    val publisher: String?,
    @field:NotNull
    val lastPageNumber: Int?,
    @field:NotNull
    val totalPage: Int?,
    @field:NotNull
    val categoryId: String?,
    val imageFile: File?

) {
    @JsonCreator
    constructor(
        title: String?, authorName: String?, bookStatus: BookStatus?,
        publisher: String?, lastPageNumber: Int?, totalPage: Int?, categoryId: String?
    ) : this(
        title = title,
        authorName = authorName,
        bookStatus = bookStatus,
        publisher = publisher,
        lastPageNumber = lastPageNumber,
        totalPage = totalPage,
        categoryId = categoryId,
        imageFile = null
    )
}
