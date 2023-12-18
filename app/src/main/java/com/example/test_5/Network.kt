package com.example.test_5

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Network {
    private const val BASE_URL = "https://run.mocky.io/v3/"

    // function to create an instance of the ApiService using Retrofit
    fun createService(): ApiService {
        // creating a Moshi instance
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        // creating a Retrofit instance
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        // returning an instance of the ApiService interface
        return retrofit.create(ApiService::class.java)
    }
}
