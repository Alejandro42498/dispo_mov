package com.example.a30songs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.a30songs.data.canciones
import com.example.a30songs.ui.theme._30songsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30songsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListaCanciones()
                }
            }
        }
    }
}

@Composable
fun ListaCanciones() {
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(canciones) { cancion ->
            ItemCancion(cancion = cancion)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ItemCancion(cancion: com.example.a30songs.data.Cancion) {
    Column {
        Image(
            painter = painterResource(id = cancion.imagenResId),
            contentDescription = stringResource(id = cancion.titulo),
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = cancion.titulo),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = stringResource(id = cancion.artista),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
