package com.jun_zheng.imageeditor.imageInfo

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jun_zheng.imageeditor.R
import com.jun_zheng.imageeditor.databinding.ImageInfoFragmentBinding

class ImageInfoFragment : Fragment() {

    private lateinit var viewModel: ImageInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = ImageInfoFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        viewModel = ImageInfoViewModel(ImageInfoFragmentArgs.fromBundle(requireArguments()).selectedProperty)
        binding.viewModel = viewModel

        val builder: AlertDialog.Builder = activity.let {
            AlertDialog.Builder(it)
        }
        builder
            .setTitle(R.string.app_name)
            .setMessage(R.string.created_time)
            .setMessage(R.string.update_time)
            .show()

        return binding.root
    }

}