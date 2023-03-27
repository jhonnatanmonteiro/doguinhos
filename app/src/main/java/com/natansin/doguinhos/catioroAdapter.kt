package com.natansin.doguinhos

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object catioroAdapter {

//usando retrofit para chamada da base url e convertendo em gson
        val apiClient: catioroApi = Retrofit.Builder()
            .baseUrl("https://dog.ceo")
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(catioroApi::class.java)

    }
