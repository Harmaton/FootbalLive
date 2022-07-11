package com.njagi.footballive.data.models.repo

import com.njagi.footballive.util.GET_INPLAY_FIXTURES
import retrofit2.http.GET

interface ElenaApiService {
    @GET(GET_INPLAY_FIXTURES)
    suspend fun getInplayMatchesResponse(): InplayMatchesResponse
}