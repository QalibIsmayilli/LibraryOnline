package com.company.library.dto.requests

import com.company.library.model.BookStatus
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.io.File

data class BookSaveRequest(

    @NotBlank
    val title: String?,
    @NotBlank
    val authorName: String?,
    @NotNull
    val bookStatus: BookStatus?,
    @NotBlank
    val publisher: String?,
    @NotNull
    val lastPageNumber: Int?,
    @NotNull
    val totalPage: Int?,
    @NotNull
    val categoryId: String?,
    val imageFile: File?

    )
