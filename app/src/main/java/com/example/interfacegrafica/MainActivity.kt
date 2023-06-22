package com.example.interfacegrafica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {

    private lateinit var myViewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myViewModel = ViewModelProvider(this)[ViewModel::class.java]

        setContent {
            MainScreen(myViewModel)
        }
    }
}

@Composable
fun MainScreen(exmpViewModel: ViewModel){
    var contadorView by remember {
        mutableStateOf(0)
    }

    val contadorProvModelView by exmpViewModel.contadorView.collectAsState()

    Column {
        Button(onClick = {
            contadorView += 1
            exmpViewModel.incrementContador()
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            )
        ){
            Text(text = "INCREMENTAR CONTADOR")
        }

        Button(onClick = {
            contadorView -= 1 //isso é considerado algo amador
            exmpViewModel.decrementContador()
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            )
        ){
            Text(text = "DECREMENTAR CONTADOR")
        }
        Text(text = "Valor do Contador Controlado pela View = $contadorView")
        Text(text = "Valor do Contador Controlado pela ViewModel = $contadorProvModelView")

        Text(text= "Nome: Rafael Oliveira Bezerra da Silva",
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
                textAlign= TextAlign.Center,
                fontWeight = FontWeight.Bold
        )


        Text(text= "RM: 22317",
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp),
                textAlign= TextAlign.Center,
                fontWeight = FontWeight.Bold)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}