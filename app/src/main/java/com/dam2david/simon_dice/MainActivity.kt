package com.dam2david.simon_dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.*


class MainActivity : AppCompatActivity() {
//contenedor de imagen
lateinit var diceImage: ImageView
// inicia el programa
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val rollButton: Button = findViewById(R.id.mi_boton)
    rollButton.setOnClickListener {
        simon_Dice()
    }

    diceImage = findViewById(R.id.imagen_dado)
}

private fun simon_Dice() {


    var i=5;

//do {
    val randomInt = Random().nextInt(3) + 1


    val drawableResource = when (randomInt) {
        1 -> R.drawable.amarillo
        2 -> R.drawable.azul
        else -> R.drawable.rojo
    }

    diceImage.setImageResource(drawableResource)

    i++

//}while(i==5)

}
}