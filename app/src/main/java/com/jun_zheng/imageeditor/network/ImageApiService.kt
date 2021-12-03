package com.jun_zheng.imageeditor.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_RUL = "http://eulerity-hackathon.appspot.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_RUL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface ImageApiService {
    @GET("image")
    suspend fun getProperties(): List<ImageProperty>
}

object ImageApi {
    val retrofitService: ImageApiService by lazy {
        retrofit.create(ImageApiService::class.java)
    }
}