package com.ashish.demo.rest

import com.ashish.demo.model.Feed
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiInterface {

    @GET
    suspend fun getFeed(
        @Url url: String
    ): Feed
}