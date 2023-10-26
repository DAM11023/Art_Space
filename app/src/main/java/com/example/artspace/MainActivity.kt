package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListadoDeFotos(
                        modifier = Modifier
                            .wrapContentSize(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
fun ListadoDeFotos(modifier: Modifier = Modifier) {
    var result by remember{mutableStateOf(1)}
    var imageResource = when (result){
        1-> R.drawable.the_knight
        2-> R.drawable.hornet_idle
        3-> R.drawable.zote_idle
        4-> R.drawable.tiso
        5-> R.drawable.quirrel
        else -> R.drawable.mister_mushroom
    }
    var textResource = when (result){
        1-> stringResource(R.string.knight)
        2-> stringResource(R.string.hornet)
        3-> stringResource(R.string.zote)
        4-> stringResource(R.string.tiso)
        5-> stringResource(R.string.quirrel)
        else -> stringResource(R.string.señor_seta)
    }
    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(imageResource),
            contentDescription = "1",
            modifier = modifier.width(500.dp).height(500.dp).fillMaxSize()
        )
        Text(text = textResource)
        Spacer(modifier = Modifier.height(16.dp))
        Row(){
        Button(onClick = {
            result = result-1
            if(result==0){
                result=6
            }
        }){
            Text(text = stringResource(R.string.previous))
        }
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick = {
                result = result+1
                if(result==7){
                    result = 1
                }
            }){
                Text(text = stringResource(R.string.next))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ListadoDeFotos(
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
        )
    }
}