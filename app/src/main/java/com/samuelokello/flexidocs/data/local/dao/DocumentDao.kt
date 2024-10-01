package com.samuelokello.flexidocs.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.samuelokello.flexidocs.data.local.enitiy.DocumentEntity

@Dao
interface DocumentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDocument(document: DocumentEntity)

    @Query("SELECT * FROM document")
    fun getAllDocuments(): List<DocumentEntity>

    @Query("SELECT * FROM document WHERE isFavorite = 1")
    fun getFavoriteDocuments(): List<DocumentEntity>

    @Query("SELECT * FROM document WHERE uri = :uri")
    fun getDocument(uri: String): DocumentEntity

    @Query("SELECT * FROM document WHERE fileName LIKE :query")
    fun searchDocuments(query: String): List<DocumentEntity>

    @Query("SELECT SUM(fileSize) FROM document")
    fun getTotalFileSize(): Long

    @Query("SELECT * FROM document WHERE dateAdded BETWEEN :start AND :end")
    fun getDocumentsAddedBetween(start: Long, end: Long): List<DocumentEntity>

    @Query("SELECT * FROM document WHERE lastAccessed BETWEEN :start AND :end")
    fun getDocumentsAccessedBetween(start: Long, end: Long): List<DocumentEntity>

    @Query("SELECT * FROM document WHERE fileType = :fileType")
    fun getDocumentsByType(fileType: String): List<DocumentEntity>

    @Query("SELECT * FROM document WHERE fileType = :fileType AND isFavorite = 1")
    fun getFavoriteDocumentsByType(fileType: String): List<DocumentEntity>

}