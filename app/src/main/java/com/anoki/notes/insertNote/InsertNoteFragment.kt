package com.anoki.notes.insertNote

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.anoki.notes.MainActivity
import com.anoki.notes.NotesViewModel
import com.anoki.notes.data.Note
import com.anoki.notes.databinding.FragmentInsertNoteBinding
import com.anoki.notes.databinding.FragmentNotesListBinding

class InsertNoteFragment : Fragment() {
    private lateinit var binding: FragmentInsertNoteBinding
    private val viewModel: NotesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInsertNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSubmit.setOnClickListener {
            handleSubmit()
        }
    }

    private fun handleSubmit() {
        val noteTitle = binding.etTitle.text.toString()
        val noteBody = binding.etBody.text.toString()
        if (noteTitle.isNotEmpty() && noteBody.isNotEmpty()) {
            viewModel.addNote(Note(null, noteTitle, noteBody))
        } else {
            emptyFieldsWarning()
        }
    }

    private fun emptyFieldsWarning() {
        Toast.makeText(
            this.context,
            "You can't enter an empty note!",
            Toast.LENGTH_SHORT)
            .show()
    }
}
