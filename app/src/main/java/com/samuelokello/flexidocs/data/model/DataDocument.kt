package com.samuelokello.flexidocs.data.model

data class DataDocument(
    val uri: String,
    val fileName: String,
    val fileType: String,
    val fileSize: Long,
    val dateAdded: Long,
    val lastAccessed: Long,
    val isFavorite: Boolean? = null
)
