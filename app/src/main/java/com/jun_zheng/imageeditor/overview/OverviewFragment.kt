package com.jun_zheng.imageeditor.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.jun_zheng.imageeditor.databinding.OverviewFragmentBinding

class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this)[OverviewViewModel::class.java]
    }
    private lateinit var binding: OverviewFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = OverviewFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.photosGrid.adapter = PhotoGridAdapter(PhotoGridAdapter.OnClickListener {
            viewModel.showEditorView(it)
        })
        viewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, {
            if (it != null) {
                this.findNavController().navigate(OverviewFragmentDirections.actionOverviewFragmentToEditorFragment(it))
                viewModel.showEditorViewComplete()
            }
        })

        return binding.root
    }
}