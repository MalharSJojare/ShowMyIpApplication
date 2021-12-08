package com.example.showmyip

import retrofit2.http.GET

interface HttpApiService {
    @GET("/ip")
    suspend fun getMyIp():IpResult
}