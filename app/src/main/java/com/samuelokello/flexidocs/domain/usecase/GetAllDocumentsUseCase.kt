// File: app/src/main/java/com/samuelokello/flexidocs/domain/usecase/GetAllDocumentsUseCase.kt
package com.samuelokello.flexidocs.domain.usecase

import com.samuelokello.flexidocs.domain.model.DocumentEntity
import com.samuelokello.flexidocs.data.repository.DocumentRepository
import com.samuelokello.flexidocs.domain.mapper.toDomainModel

class GetAllDocumentsUseCase(private val repository: DocumentRepository) {
    fun execute(): List<DocumentEntity> {
        return repository.getAllDocuments().map { it.toDomainModel() }
    }
}