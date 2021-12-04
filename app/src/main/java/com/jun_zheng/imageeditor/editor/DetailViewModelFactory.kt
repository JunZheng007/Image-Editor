package com.jun_zheng.imageeditor.editor

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jun_zheng.imageeditor.network.ImageProperty

class DetailViewModelFactory (
    private val imageProperty: ImageProperty,
    private val application: Application) : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
                return DetailViewModel(imageProperty, application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
}