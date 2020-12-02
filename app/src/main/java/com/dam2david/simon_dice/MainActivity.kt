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

        val text = getString(R.string.mensajeToast1)
        val toast= Toast.makeText(applicationContext,text,declaracion)




        val rollButton: Button = findViewById(R.id.mi_boton)
        rollButton.setOnClickListener {
           rondaOrdenador()
            toast.show()

        }


        val comprobarBoton: Button = findViewById(R.id.mi_boton2)
        comprobarBoton.setOnClickListener{

            limpiarListas()

        }


        val comprobarRonda: Button = findViewById(R.id.button3)
        comprobarRonda.setOnClickListener {

            comprobarResultado()

        }


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



        diceImage = findViewById(R.id.imagen_rgb)
    }

    private fun comprobarResultado() {

        val text2 = getString(R.string.mensajeToast2)
        val toast2= Toast.makeText(applicationContext,text2,declaracion)
        val text3 = getString(R.string.mensajeToast3)
        val toast3= Toast.makeText(applicationContext,text3,declaracion)

        if (listaordenador==listajugador) {

            toast2.show()

            rondas++;


        } else {

            toast3.show()





        }
    }


    private fun limpiarListas(){

        listaordenador.value?.clear()
        listajugador.value?.clear()



    }



    private fun rondaOrdenador() {


    //while (rondas!=rondas) {
    val randomInt = Random.nextInt(4) + 1

    listaordenador.value?.add(randomInt)
    listaordenador.postValue(listaordenador.value)


    val drawableResource = when (randomInt) {
        1 -> R.drawable.amarillo
        2 -> R.drawable.azul
        3 -> R.drawable.rojo
        else -> R.drawable.verde
    }

    diceImage.setImageResource(drawableResource)

//}







            }
        }







