package com.anoki.notes.data

import androidx.room.*

@Entity
data class Note (
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "body") val body: String
)

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAll(): List<Note>

    @Insert
    fun insertNote(vararg note: Note)
}

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}
