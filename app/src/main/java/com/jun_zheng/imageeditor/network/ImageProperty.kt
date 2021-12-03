package com.jun_zheng.imageeditor.network;

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageProperty(
    val url: String,
    val created: String,
    val updated: String
) : Parcelable
