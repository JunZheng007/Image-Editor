package com.jun_zheng.imageeditor.imageInfo

import android.app.Activity
import android.app.AlertDialog
import android.app.Application
import androidx.lifecycle.*
import com.jun_zheng.imageeditor.R
import com.jun_zheng.imageeditor.network.ImageProperty

class ImageInfoViewModel(imageProperty: ImageProperty) : ViewModel() {
    private val _selectedProperty = MutableLiveData(imageProperty)
    val selectedProperty: LiveData<ImageProperty>
        get() = _selectedProperty



//    val displayCreatedTime = Transformations.map(_selectedProperty) {
//        app.applicationContext.getString(R.string.created_time, it.created)
//    }
//
//    val displayUpdateTime = Transformations.map(_selectedProperty) {
//        app.applicationContext.getString(R.string.update_time, it.updated)
//    }
}