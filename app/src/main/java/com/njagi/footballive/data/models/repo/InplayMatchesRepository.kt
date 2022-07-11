package com.njagi.footballive.data.models.repo

import javax.inject.Inject

class InplayMatchesRepository @Inject constructor(private val elenaApiService: ElenaApiService) {
   suspend fun getAllInplayMatches() : List<Match> = elenaApiService.getInplayMatchesResponse().data

}