package com.ashish.demo.rest

open class RepositoryImplementation(
    private var apiInterface: ApiInterface
) {
    suspend fun getFeeds(url: String) = apiInterface.getFeed(url)
}