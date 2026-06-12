package upch.rrodriguez.practicacinco_moviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import upch.rrodriguez.practicacinco_moviles.ui.theme.Practicacinco_MovilesTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            trackeadorgym()
        }
    }
}


@Composable

fun trackeadorgym(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicio"
    ){

        composable("inicio") {
            Iniciospantalla(navController)
        }

        composable("detalles") {
            Detallepantalla(navController)
        }
    }
}

@Composable

fun Iniciospantalla(navController: NavController){

    var listo by remember{
        mutableStateOf(false)
    }

    val Forma =
        if (listo)
            RoundedCornerShape(20.dp)
        else
            RoundedCornerShape(3.dp)

    val Texto =
        if (listo)
            "rutina completado"
        else
            "marcar como completado"

    val Color =
        if (listo)
            MaterialTheme.colorScheme.tertiary
        else
            MaterialTheme.colorScheme.primary

    Surface(modifier = Modifier.fillMaxSize()) {

        Column (

            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        )

        {
            Text(
                text = "rutina del lunes: piernas y espalda",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(30.dp))


            Button(
                onClick = {
                    listo = !listo
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color
                ),
                shape = Forma
            ) {

                Text(
                    text = Texto,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.height(30.dp) )

            Button(
                onClick = {
                    navController.navigate("detalles")
                }
            ) {
                Text("Mirar ejercicios")
                }
            }
        }
    }



@Composable

fun Detallepantalla(navController: NavController){

    Surface(modifier = Modifier.fillMaxSize()
    ){

       Column(modifier = Modifier
           .fillMaxSize()
           .padding(20.dp),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally
       ) {
           Text(
               text =
                   "1. Leg press: 4x10\n2. Sentadilla frontal: 3x12\n 3. Pull Over: 2x15",

               style = MaterialTheme.typography.bodyLarge
           )

           Spacer(modifier = Modifier.height(30.dp))

           Button(
               onClick = {
                   navController.popBackStack()
               }
           ){
               Text("Regresar")
           }

       }

    }

}

@Preview(showBackground = true)
@Composable

fun vistaprevia(){
    trackeadorgym()
}