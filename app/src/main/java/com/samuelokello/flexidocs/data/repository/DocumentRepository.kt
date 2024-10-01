package com.samuelokello.flexidocs.data.repository

import com.samuelokello.flexidocs.data.model.DataDocument

interface DocumentRepository {
    fun insertDocument(document: DataDocument)
    fun getAllDocuments(): List<DataDocument>
    fun getFavoriteDocuments(): List<DataDocument>
    fun getDocument(uri: String): DataDocument
    fun searchDocuments(query: String): List<DataDocument>
    fun getTotalFileSize(): Long
    fun getDocumentsAddedBetween(start: Long, end: Long): List<DataDocument>
    fun getDocumentsAccessedBetween(start: Long, end: Long): List<DataDocument>
    fun getDocumentsByType(fileType: String): List<DataDocument>
    fun getFavoriteDocumentsByType(fileType: String): List<DataDocument>
}