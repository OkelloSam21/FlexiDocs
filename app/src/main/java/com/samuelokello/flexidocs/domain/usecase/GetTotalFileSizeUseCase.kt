// File: app/src/main/java/com/samuelokello/flexidocs/domain/usecase/GetTotalFileSizeUseCase.kt
package com.samuelokello.flexidocs.domain.usecase

import com.samuelokello.flexidocs.data.repository.DocumentRepository

class GetTotalFileSizeUseCase(private val repository: DocumentRepository) {
    fun execute(): Long {
        return repository.getTotalFileSize()
    }
}