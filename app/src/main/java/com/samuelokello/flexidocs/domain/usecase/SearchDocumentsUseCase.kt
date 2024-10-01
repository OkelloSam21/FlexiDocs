// File: app/src/main/java/com/samuelokello/flexidocs/domain/usecase/SearchDocumentsUseCase.kt
package com.samuelokello.flexidocs.domain.usecase

import com.samuelokello.flexidocs.domain.model.DocumentEntity
import com.samuelokello.flexidocs.data.repository.DocumentRepository
import com.samuelokello.flexidocs.domain.mapper.toDomainModel

class SearchDocumentsUseCase(private val repository: DocumentRepository) {
    fun execute(query: String): List<DocumentEntity> {
        return repository.searchDocuments(query).map { it.toDomainModel() }
    }
}