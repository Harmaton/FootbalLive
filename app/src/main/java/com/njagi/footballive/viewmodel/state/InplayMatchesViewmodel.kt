package com.njagi.footballive.viewmodel.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.njagi.footballive.data.models.repo.InplayMatchesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class InplayMatchesViewmodel @Inject constructor(private val inplayMatchesRepository: InplayMatchesRepository): ViewModel() {
private val _inplayMatchesState = MutableStateFlow<MatchesState>(MatchesState.Empty)
    val inplayMatchesState: StateFlow<MatchesState> = _inplayMatchesState

    init {
        getAllInplayMatches()
    }

    private fun getAllInplayMatches(){
        _inplayMatchesState.value = MatchesState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val inplayMatchesResponse = inplayMatchesRepository.getAllInplayMatches()
                _inplayMatchesState.value = MatchesState.Success(inplayMatchesResponse)
            } catch (exception: HttpException){
                _inplayMatchesState.value = MatchesState.Error("No Internet Connection")
            } catch (exception: IOException){
                _inplayMatchesState.value = MatchesState.Error("Something Went Wrong")
            }
        }
    }
}
