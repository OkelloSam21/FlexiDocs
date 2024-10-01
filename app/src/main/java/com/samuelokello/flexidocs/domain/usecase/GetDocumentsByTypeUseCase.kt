// File: app/src/main/java/com/samuelokello/flexidocs/domain/usecase/GetDocumentsByTypeUseCase.kt
package com.samuelokello.flexidocs.domain.usecase

import com.samuelokello.flexidocs.domain.model.DocumentEntity
import com.samuelokello.flexidocs.data.repository.DocumentRepository
import com.samuelokello.flexidocs.domain.mapper.toDomainModel

class GetDocumentsByTypeUseCase(private val repository: DocumentRepository) {
    fun execute(fileType: String): List<DocumentEntity> {
        return repository.getDocumentsByType(fileType).map { it.toDomainModel() }
    }
}