package com.example.interfacegrafica

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.interfacegrafica.ui.theme.InterfaceGraficaTheme
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {
    private lateinit var minhaViewModelBemSimples: MinhaViewModelBemSimples
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        minhaViewModelBemSimples = ViewModelProvider(this).get(MinhaViewModelBemSimples::class.java)
        setContent {
           MainScreen(minhaViewModelBemSimples)
        }
    }
}
@Composable
fun MainScreen(umaViewModel: MinhaViewModelBemSimples)
{
    var contadorNaView by remember{
        mutableStateOf(0)
    }
    val contadorProvenienteDaMinhaViewModelBemSimples by umaViewModel.contadorDaViewPublico.collectAsState()

    Column() {
        Button(onClick =
        {
            contadorNaView = contadorNaView+1 //coisa de estudante
            umaViewModel.incremenaContador() // isso a  aqui é prof
        })
        {
            Text(text = "INCRIMENTA CONTADOR")
        }
        Text(text = "Vlr do contador View = $contadorNaView")
        Text(text = "Vlr do contador ViewModel = $contadorProvenienteDaMinhaViewModelBemSimples")
    }
}

@Composable
fun MinhaSaudacao(
    nomeX: String = "World",
    adjNome: String,
    mod: Modifier) {
    Text(text = "Oie, $nomeX $adjNome", modifier = mod)
}
@Composable
fun Greeting(name: String, mod: Modifier = Modifier)
{
    Text(
        text = "Hello $name!",
        modifier = mod
    )
}

@Preview(showBackground = true)
@Composable
fun MinhaPreview()
{
    // MainScreen()
    Text(text = "Oie")
}