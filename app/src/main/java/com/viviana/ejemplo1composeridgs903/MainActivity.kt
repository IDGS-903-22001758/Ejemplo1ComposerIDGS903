package com.viviana.ejemplo1composeridgs903

import android.annotation.SuppressLint
import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.os.Message
import android.os.Messenger
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ColorInt
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


private val tarjetas:List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("Goku","El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla."),
    PersonajeTarjeta("Master Roshi","Maestro de artes marciales y mentor de Goku. Conocido bajo el nombre de Muten Rosh, fue en su momento el terrícola más fuerte de la Tierra, y mucha gente lo recuerda como el \"Dios de las Artes Marciales\", pero antes de poder ostentar dicho título tuvo que trabajar y estudiar las artes marciales con su maestro Mutaito y su eterno rival Tsuru-Sen'nin."),
    PersonajeTarjeta("Gohan","Son Gohanda en su tiempo en España, o simplemente Gohan en Hispanoamérica, es uno de los personajes principales de los arcos argumentales de Dragon Ball Z, Dragon Ball Super y Dragon Ball GT. Es un mestizo entre saiyano y humano terrícola."),
    PersonajeTarjeta("Whis","Whis es uno de los hijos del Gran Sacerdote, hermano menor de Vados, Korn y Kus. Es el ángel guía encargado de asistir y servir como maestro al Dios de la Destrucción del Universo 7, Beerus."),
    PersonajeTarjeta("Bills","Dios de la Destrucción Beerus, conocido también como Beers, o Bills en Hispanoamérica e inicialmente en España[1], es un personaje que fue introducido en la película Dragon Ball Z: La batalla de los dioses, donde es el antagonista principal de la película, y que aparece en el manga y anime de Dragon Ball Super como un personaje principal."),
    PersonajeTarjeta("Kaio del norte (Kaito)","Se trata del dios encargado de administrar las Galaxias del Norte, el cuadrante boreal del Universo 7 y supervisar a los dioses de los planetas de dicho sector (como es el caso de Kami en la Tierra)"),
    PersonajeTarjeta("Trunks","Hijo de Vegeta y Bulma. Es un mestizo entre humano terrícola y Saiyano nacido en la Tierra, e hijo de Bulma y Vegeta, el cual es introducido en el Arco de los Androides y Cell."),
    PersonajeTarjeta("Piccolo","Es un namekiano que surgió tras ser creado en los últimos momentos de vida de su padre, siendo su actual reencarnación. Aunque en un principio fue el archienemigo de Son Goku, con el paso del tiempo fue haciéndose menos malvado hasta finalmente convertirse en un ser bondadoso y miembro de los Guerreros Z."),
    PersonajeTarjeta("Dende","Sucesor de Piccolo como el nuevo Namekian protector de la Tierra. Es un pequeño namekiano, que vivía en el poblado de Moori, junto a su hermano Scargo y otros tantos de su especie. Es el hijo 108 del Gran Patriarca y posteriormente Dios de la Tierra, sustituyendo a Dios."),
    PersonajeTarjeta("Zeno","Zeno es el ser supremo del multiverso y tiene un poder abrumador .")
)
data class PersonajeTarjeta(val title: String, val body: String)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Ejemplo1ComposerIDGS903Theme {
                Tarjeta(tarjetas)
            }

        }
    }
}



@Composable
fun Personaje(name:String, color: Color,style:TextStyle) {
    Text(text = name)

}

@Composable
fun Personajes(personaje: PersonajeTarjeta){
    Column {
        Personaje(personaje.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.headlineMedium)

        Personaje(personaje.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta>){
    LazyColumn {
      items(personajes){    personaje ->
          MyPersonajes(personaje)
      }
    }
}

@Composable
fun MyPersonajes(personaje: PersonajeTarjeta){
    Card (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){

    }
    Row(
      modifier = Modifier.padding(8.dp)
          .background(MaterialTheme.colorScheme.background)
    ) {
        ImagenHeroe()
        Personajes(personaje)
    }

}

@Composable
fun ImagenHeroe(){
    Image(
        painter = painterResource(R.drawable.logo_dragonballapi),
        contentDescription ="Goku",
        modifier= Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.tertiary)
    )
}

@Preview
@Composable
fun GreetingPreview(){
    Tarjeta(tarjetas)
}