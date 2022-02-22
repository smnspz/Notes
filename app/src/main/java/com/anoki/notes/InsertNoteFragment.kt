package com.anoki.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anoki.notes.databinding.FragmentInsertNoteBinding
import com.anoki.notes.databinding.FragmentNotesListBinding

class InsertNoteFragment : Fragment() {
    private lateinit var binding: FragmentInsertNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInsertNoteBinding.inflate(inflater, container, false)
        return binding.root
    }
}
