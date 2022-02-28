package com.anoki.notes.notesList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anoki.notes.NotesViewModel
import com.anoki.notes.data.Note
import com.anoki.notes.databinding.RowItemNoteBinding

class NotesListAdapter(private val notesList: List<Note>) :
    RecyclerView.Adapter<NotesListAdapter.ViewHolder>() {

    class ViewHolder(binding: RowItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        private val noteTitle = binding.twNoteTitle
        private val noteBody = binding.twNoteBody

        fun bind(note: Note) {
            itemView.apply {
                noteTitle.text = note.title
                noteBody.text = note.body
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(notesList[position])
    }

    override fun getItemCount(): Int = notesList.size
}