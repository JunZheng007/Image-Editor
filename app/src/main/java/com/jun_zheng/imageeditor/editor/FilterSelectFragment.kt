package com.jun_zheng.imageeditor.editor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jun_zheng.imageeditor.databinding.FilterSelectFragmentBinding
import ja.burhanrashid52.photoeditor.PhotoFilter

val filter = arrayListOf(PhotoFilter.AUTO_FIX, PhotoFilter.BLACK_WHITE)

class FilterSelectFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FilterSelectFragmentBinding.inflate(inflater)



        return binding.root
    }

}