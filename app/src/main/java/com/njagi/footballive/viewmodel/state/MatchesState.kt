package com.njagi.footballive.viewmodel.state

import com.njagi.footballive.data.models.repo.Match

sealed class MatchesState {
    object Empty: MatchesState()
    object Loading:MatchesState()
    class Success(val data: List<Match>): MatchesState()
    class Error(val message: String) : MatchesState()
}