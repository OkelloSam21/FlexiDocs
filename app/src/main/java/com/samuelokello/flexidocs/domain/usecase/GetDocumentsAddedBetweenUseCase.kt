// File: app/src/main/java/com/samuelokello/flexidocs/domain/usecase/GetDocumentsAddedBetweenUseCase.kt
package com.samuelokello.flexidocs.domain.usecase

import com.samuelokello.flexidocs.domain.model.DocumentEntity
import com.samuelokello.flexidocs.data.repository.DocumentRepository
import com.samuelokello.flexidocs.domain.mapper.toDomainModel

class GetDocumentsAddedBetweenUseCase(private val repository: DocumentRepository) {
    fun execute(start: Long, end: Long): List<DocumentEntity> {
        return repository.getDocumentsAddedBetween(start, end).map { it.toDomainModel() }
    }
}