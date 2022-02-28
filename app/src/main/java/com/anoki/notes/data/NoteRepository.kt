package com.anoki.notes.data

import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NoteRepository(private val dao : NoteDao) {

    val allNotes: LiveData<List<Note>> = dao.getAll()

    suspend fun listNotes(): LiveData<List<Note>> = withContext(Dispatchers.IO) {
        dao.getAll()
    }

    suspend fun addNote(note: Note) {
        withContext(Dispatchers.IO) {
            dao.insertNote(note)
            Log.d(note.toString(), "Inserted note")
        }
    }
}