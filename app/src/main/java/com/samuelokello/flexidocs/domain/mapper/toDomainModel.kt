// File: app/src/main/java/com/samuelokello/flexidocs/domain/mapper/DocumentMapper.kt
package com.samuelokello.flexidocs.domain.mapper

import com.samuelokello.flexidocs.data.model.DataDocument
import com.samuelokello.flexidocs.domain.model.DocumentEntity as DomainDocument

fun DataDocument.toDomainModel() = DomainDocument(
    uri = uri,
    fileName = fileName,
    fileType = fileType,
    fileSize = fileSize,
    dateAdded = dateAdded,
    lastAccessed = lastAccessed,
    isFavorite = isFavorite
)

fun DomainDocument.toDataModel() = DataDocument(
    uri = uri,
    fileName = fileName,
    fileType = fileType,
    fileSize = fileSize,
    dateAdded = dateAdded,
    lastAccessed = lastAccessed,
    isFavorite = isFavorite
)