package com.anoki.notes.notesList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.anoki.notes.NotesViewModel
import com.anoki.notes.data.Note
import com.anoki.notes.databinding.FragmentNotesListBinding

class NotesListFragment : Fragment() {
    private lateinit var binding: FragmentNotesListBinding
    private lateinit var adapter: NotesListAdapter
    private val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotesListBinding.inflate(inflater, container, false)
        setupUI(binding)
        return binding.root
    }

    private fun setupUI(binding: FragmentNotesListBinding) {
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        viewModel.allNotes.observe(viewLifecycleOwner, Observer {
            adapter = NotesListAdapter(it)
        })
        binding.recyclerView.adapter = adapter
    }
}