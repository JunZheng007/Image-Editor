package com.jun_zheng.imageeditor.editor

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jun_zheng.imageeditor.network.ImageProperty

class DetailViewModel(imageProperty: ImageProperty, app: Application) : AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData(imageProperty)
    val selectedProperty: LiveData<ImageProperty>
        get() = _selectedProperty
}