// File: app/src/main/java/com/samuelokello/flexidocs/domain/model/Document.kt
package com.samuelokello.flexidocs.domain.model

data class DocumentEntity(
    val uri: String,
    val fileName: String,
    val fileType: String,
    val fileSize: Long,
    val dateAdded: Long,
    val lastAccessed: Long,
    val isFavorite: Boolean? = null
)