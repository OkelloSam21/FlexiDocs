package com.samuelokello.flexidocs.data.mapper

import com.samuelokello.flexidocs.data.local.enitiy.DocumentEntity
import com.samuelokello.flexidocs.data.model.DataDocument

fun DocumentEntity.asDataDocument() = DataDocument (
    uri = uri,
    fileName = fileName,
    fileType = fileType,
    fileSize = fileSize,
    dateAdded = dateAdded,
    lastAccessed = lastAccessed,
    isFavorite = isFavorite
)