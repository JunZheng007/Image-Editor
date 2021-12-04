package com.jun_zheng.imageeditor.editor

import android.app.AlertDialog
import android.opengl.Visibility
import android.os.Bundle
import android.view.*
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.jun_zheng.imageeditor.R
import com.jun_zheng.imageeditor.databinding.DetailFragmentBinding
import ja.burhanrashid52.photoeditor.PhotoEditor
import ja.burhanrashid52.photoeditor.PhotoFilter

class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val application = requireNotNull(activity).application
        val binding = DetailFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner

        val imageProperty = DetailFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = DetailViewModelFactory(imageProperty, application)
        viewModel = ViewModelProvider(this, viewModelFactory)[DetailViewModel::class.java]
        binding.viewModel = viewModel

        val textFont = ResourcesCompat.getFont(this.requireContext(), R.font.roboto_medium)

        val editor = PhotoEditor.Builder(this.context, binding.photoEditorView)
            .setClipSourceImage(true)
            .setPinchTextScalable(true)
            .setDefaultTextTypeface(textFont)
            .build()

        binding.text.setOnClickListener {
            binding.inputText.visibility = View.VISIBLE
        }

//        binding.inputText.setOnEditorActionListener { textView: TextView, i: Int, keyEvent: KeyEvent ->
//            when (i) {
//                EditorInfo.IME_ACTION_DONE -> { editor.addText(textView.text.toString(), 555733)}
//                else -> { return Unit }
//            }
//        }

        binding.filter.setOnClickListener {
            binding.editorSelect.visibility = View.INVISIBLE
            binding.filterSelect.visibility = View.VISIBLE
            binding.filterClose.visibility = View.VISIBLE

        }
        binding.filterClose.setOnClickListener {
            binding.editorSelect.visibility = View.VISIBLE
            binding.filterSelect.visibility = View.INVISIBLE
            binding.filterClose.visibility = View.INVISIBLE
        }

        binding.none.setOnClickListener {
            editor.setFilterEffect(PhotoFilter.NONE)
        }

        binding.autoFix.setOnClickListener {
            editor.setFilterEffect(PhotoFilter.AUTO_FIX)
        }

        binding.blackWhite.setOnClickListener {
            editor.setFilterEffect(PhotoFilter.BLACK_WHITE)
        }

        binding.brightness.setOnClickListener {
            editor.setFilterEffect(PhotoFilter.BRIGHTNESS)
        }

        binding.fishEye.setOnClickListener {
            editor.setFilterEffect(PhotoFilter.FISH_EYE)
        }

        binding.contrast.setOnClickListener {
            editor.setFilterEffect(PhotoFilter.CONTRAST)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.detail_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.information_menu -> showImageInfo()
            R.id.edit_menu -> openEditPage()
            R.id.download_menu -> uploadImage()
        }

        return true
    }

    private fun showImageInfo() {
        val builder: AlertDialog.Builder = activity.let {
            AlertDialog.Builder(it)
        }
        builder
            .setMessage(
                getString(
                    R.string.created_time,
                    viewModel.selectedProperty.value?.created
                ) + getString(R.string.update_time, viewModel.selectedProperty.value?.updated)
            )
            .show()
    }

    private fun openEditPage() {
        TODO("Not yet implemented")
    }

    private fun uploadImage() {

    }
}