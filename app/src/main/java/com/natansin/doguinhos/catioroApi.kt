package com.natansin.doguinhos

import retrofit2.Response
import retrofit2.http.GET

interface catioroApi {


        @GET("/api/breeds/image/random")
        suspend fun getRandomImage() : Response<catiorroImagenModel>



}