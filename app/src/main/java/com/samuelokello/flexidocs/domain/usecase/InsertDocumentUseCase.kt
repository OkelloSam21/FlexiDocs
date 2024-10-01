// File: app/src/main/java/com/samuelokello/flexidocs/domain/usecase/InsertDocumentUseCase.kt
package com.samuelokello.flexidocs.domain.usecase

import com.samuelokello.flexidocs.data.repository.DocumentRepository
import com.samuelokello.flexidocs.data.model.DataDocument

class InsertDocumentUseCase(private val repository: DocumentRepository) {
    fun execute(document: DataDocument) {
        repository.insertDocument(document)
    }
}