package com.anoki.notes.data

import androidx.lifecycle.LiveData

class NoteRepository(private val dao : NoteDao) {

    val listNotes: LiveData<List<Note>> = dao.getAll()

    suspend fun addNote(note: Note) = dao.insertNote(note)
}