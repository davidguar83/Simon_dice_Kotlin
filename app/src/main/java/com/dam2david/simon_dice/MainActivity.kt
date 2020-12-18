@file:Suppress("UNUSED_VARIABLE")

package com.dam2david.simon_dice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    //contenedor de imagen
    lateinit var diceImage: ImageView


    val declaracion= Toast.LENGTH_SHORT

    private var listaordenador = MutableLiveData<MutableList<Int>>()
    private var listajugador = MutableLiveData<MutableList<Int>>()



    var rondas = 1

    var puntos = 0
    var puntostotal = 0
    var rondaspuntos = 0
    var rondasjugador = 0


    // inicia el programa
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//creo mensaje de texto y lo meto en una toast
        val text = getString(R.string.mensajeToast1)
        val toast= Toast.makeText(applicationContext,text,declaracion)



//sirve para cuando presiones el boton empezar se inicie la ronda de la maquina seguido del mensaje de la toas y por ultimo empieza el turno jugador
        val rollButton: Button = findViewById(R.id.mi_boton)
        rollButton.setOnClickListener {
           rondaOrdenador()
            toast.show()
            turnoJugador()

        }

//sirve para cuando presiones el boton haga lo del metoso limpiar lista()
        val comprobarBoton: Button = findViewById(R.id.mi_boton2)
        comprobarBoton.setOnClickListener{

            limpiarListas()

        }

//comprueva las dos listas en caso de estar correctas , incrementa en +1 las ronda
        val comprobarRonda: Button = findViewById(R.id.button3)
        comprobarRonda.setOnClickListener {

            comprobarResultado()

        }







        diceImage = findViewById(R.id.imagen_rgb)
    }

// metodo para guardar en la lista jugador los colores o mas vien los numeros, para despues compararlos con la lista ordenador
    private fun turnoJugador(){

        val botonVerde: Button = findViewById(R.id.buttonverde)
        botonVerde.setOnClickListener {
            listajugador.value?.add(4)

        }
        val botonRojo: Button = findViewById(R.id.buttonrojo)
        botonVerde.setOnClickListener {
            listajugador.value?.add(3)
        }


        val botonAzul: Button = findViewById(R.id.buttonazul)
        botonVerde.setOnClickListener {
            listajugador.value?.add(2)
        }

        val botonAmarillo: Button = findViewById(R.id.buttonamarillo)
        botonVerde.setOnClickListener {
            listajugador.value?.add(1)
        }




    }
//metodo para limpiar las listas tanto jugador como maquina, no mantiene la dinamica original del juego, pero es una posible variable curiosa, ya que limpia las listas creando el juego de nuevo pero con una ronda mas de color, sin mantener el color inicial
    private fun comprobarResultado() {

        val text2 = getString(R.string.mensajeToast2)
        val toast2= Toast.makeText(applicationContext,text2,declaracion)
        val text3 = getString(R.string.mensajeToast3)
        val toast3= Toast.makeText(applicationContext,text3,declaracion)

        if (listaordenador.value==listajugador.value) {

            toast2.show()

            rondas++
            limpiarListas()
            //listajugador.value?.clear()
            rondaOrdenador()

        } else {

            toast3.show()





        }
    }

//metodo que limpia las dos listasmutables
    private fun limpiarListas(){

        listaordenador.value?.clear()
        listajugador.value?.clear()



    }


// metodo que genera una combinacion de numeros que se almacenan en una lista mutable, cambia cada numero con una imagen que equivale a un color en concreto
    private fun rondaOrdenador() {


//abria que hacer una coroutina para que los colores se ejecutaran con una diferencia de tiempo, para poder ser vistos por el ojo humano
        for (i in 1..rondas)  {
            val randomInt = (1+Random.nextInt(4) )

            listaordenador.value?.add(randomInt)
            listaordenador.postValue(listaordenador.value)


            val drawableResource = when (randomInt) {
                1 -> R.drawable.amarillo
                2 -> R.drawable.azul
                3 -> R.drawable.rojo
                else -> R.drawable.verde
            }

            diceImage.setImageResource(drawableResource)

        }

    }






        }







