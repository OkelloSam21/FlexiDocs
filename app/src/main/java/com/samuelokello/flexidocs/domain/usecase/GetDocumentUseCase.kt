// File: app/src/main/java/com/samuelokello/flexidocs/domain/usecase/GetDocumentUseCase.kt
package com.samuelokello.flexidocs.domain.usecase

import com.samuelokello.flexidocs.domain.model.DocumentEntity
import com.samuelokello.flexidocs.data.repository.DocumentRepository
import com.samuelokello.flexidocs.domain.mapper.toDomainModel

class GetDocumentUseCase(private val repository: DocumentRepository) {
    fun execute(uri: String): DocumentEntity {
        return repository.getDocument(uri).toDomainModel()
    }
}