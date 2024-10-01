package com.samuelokello.flexidocs.data.local.enitiy

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "document")
data class DocumentEntity(
    @PrimaryKey val uri: String,
    val fileName: String,
    val fileType: String,
    val fileSize: Long,
    val dateAdded: Long,
    val lastAccessed: Long,
    val isFavorite: Boolean? = null
)
