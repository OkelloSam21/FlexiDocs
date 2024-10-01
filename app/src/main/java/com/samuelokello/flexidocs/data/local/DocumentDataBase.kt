package com.samuelokello.flexidocs.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.samuelokello.flexidocs.data.local.dao.DocumentDao
import com.samuelokello.flexidocs.data.local.enitiy.DocumentEntity

@Database(entities = [DocumentEntity::class], version = 1, exportSchema = false)
abstract class DocumentDataBase: RoomDatabase() {
    abstract fun documentDao(): DocumentDao

}