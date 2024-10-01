// File: app/src/main/java/com/samuelokello/flexidocs/domain/usecase/GetDocumentsAccessedBetweenUseCase.kt
package com.samuelokello.flexidocs.domain.usecase

import com.samuelokello.flexidocs.domain.model.DocumentEntity
import com.samuelokello.flexidocs.data.repository.DocumentRepository
import com.samuelokello.flexidocs.domain.mapper.toDomainModel

class GetDocumentsAccessedBetweenUseCase(private val repository: DocumentRepository) {
    fun execute(start: Long, end: Long): List<DocumentEntity> {
        return repository.getDocumentsAccessedBetween(start, end).map { it.toDomainModel() }
    }
}