package com.jun_zheng.imageeditor;

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jun_zheng.imageeditor.network.ImageProperty
import com.jun_zheng.imageeditor.overview.PhotoGridAdapter
import ja.burhanrashid52.photoeditor.PhotoEditorView

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(imageView)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<ImageProperty>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("photo_src")
fun bindPhotoEditor(photoEditorView: PhotoEditorView, photo_src: String?) {
    photo_src?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(photoEditorView.context)
            .load(imgUri)
            .into(photoEditorView.source)
    }
}
