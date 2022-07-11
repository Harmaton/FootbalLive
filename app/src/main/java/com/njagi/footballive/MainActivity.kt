package com.njagi.footballive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.njagi.footballive.ui.theme.FootbalLiveTheme
import com.njagi.footballive.viewmodel.state.InplayMatchesViewmodel
import com.njagi.footballive.viewmodel.state.MatchesState
import com.njagi.footballive.viewmodel.state.MatchesState.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FootbalLiveTheme {
            Column(modifier = Modifier.padding(10.dp)) {
            TopAppBar()
            FetchData()
            }

            }
        }
    }
}
@Composable
fun FetchData(inplayMatchesViewmodel: InplayMatchesViewmodel = viewModel()) {
    Column (){
        when(val state = inplayMatchesViewmodel.inplayMatchesState.collectAsState().value){
            is Empty -> Text(text = "No data available")
            is Loading -> Text(text = "Loading ....")
            is Success -> Text(text = "Successfull")
            is Error -> Text(text = state.message)
        }

    }

}

@Composable
fun TopAppBar( ){
    Row(modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically)
    {
        
    IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Default.Refresh, contentDescription = "Refresh Icon")
    }


    Text(text = "FootbalLive", style = MaterialTheme.typography.h4, color = Color.Black)


        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "toggle mode- get moon!!")
        }

        
    }

}



























