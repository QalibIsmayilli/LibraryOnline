package com.company.library.dto.requests

import com.company.library.model.BookStatus
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

}
