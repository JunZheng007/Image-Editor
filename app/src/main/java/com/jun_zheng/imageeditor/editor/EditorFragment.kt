package com.jun_zheng.imageeditor.editor

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jun_zheng.imageeditor.R
import com.jun_zheng.imageeditor.databinding.EditorFragmentBinding

class EditorFragment : Fragment() {

    private lateinit var binding: EditorFragmentBinding
    private lateinit var viewModel: EditorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val application = requireNotNull(activity).application
        binding = EditorFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val imageProperty = EditorFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = EditorViewModelFactory(imageProperty, application)
        viewModel = ViewModelProvider(this, viewModelFactory)[EditorViewModel::class.java]
        binding.viewModel = viewModel

        return binding.root
    }


}