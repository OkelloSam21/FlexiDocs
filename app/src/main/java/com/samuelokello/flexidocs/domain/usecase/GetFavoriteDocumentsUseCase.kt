// File: app/src/main/java/com/samuelokello/flexidocs/domain/usecase/GetFavoriteDocumentsUseCase.kt
package com.samuelokello.flexidocs.domain.usecase

import com.samuelokello.flexidocs.domain.model.DocumentEntity
import com.samuelokello.flexidocs.data.repository.DocumentRepository
import com.samuelokello.flexidocs.domain.mapper.toDomainModel

class GetFavoriteDocumentsUseCase(private val repository: DocumentRepository) {
    fun execute(): List<DocumentEntity> {
        return repository.getFavoriteDocuments().map { it.toDomainModel() }
    }
}