package com.jun_zheng.imageeditor.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jun_zheng.imageeditor.network.ImageApi
import com.jun_zheng.imageeditor.network.ImageProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {

    private val _properties = MutableLiveData<List<ImageProperty>>()
    val properties: LiveData<List<ImageProperty>>
        get() = _properties

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob.plus(Main))

    private val _navigateToSelectedProperty = MutableLiveData<ImageProperty?>()
    val navigateToSelectedProperty: MutableLiveData<ImageProperty?>
        get() = _navigateToSelectedProperty

    init {
        getImageProperties()
    }

    private fun getImageProperties() {
        coroutineScope.launch {
            try {
                Log.i("ViewModel", "loading data")
                val listResult = ImageApi.retrofitService.getProperties()
                _properties.value = listResult
            } catch (t: Throwable) {
                _properties.value = ArrayList()
                Log.i("ViewModel", t.message.toString())
            }
        }
    }

    fun showEditorView(imageProperty: ImageProperty) {
        _navigateToSelectedProperty.value = imageProperty
    }

    fun showEditorViewComplete() {
        _navigateToSelectedProperty.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}