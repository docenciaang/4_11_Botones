//=============================================================
// CL
//
//=============================================================
package com.example.a4_11_botones

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btElegir.setOnClickListener{
            if((cbJava.isChecked == true) &&(cbKotlin.isChecked == true)){
                Toast.makeText(this,"Kotlin + Java",Toast.LENGTH_SHORT).show()

            } else if (cbKotlin.isChecked == true){
                Toast.makeText(this, "Solo Kotlin",Toast.LENGTH_SHORT).show()
            }
            else if (cbJava.isChecked == true){
                Toast.makeText(this,"Solo Java",Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(this, "Ninguno", Toast.LENGTH_SHORT).show()
        }


        //================================================================
        //  radio button
        //================================================================
        rgRadioGrupo.setOnCheckedChangeListener{ _ , checkId ->

            when (checkId){
                R.id.rbRojo -> llRojoVerde.setBackgroundColor(Color.RED)
                R.id.rbVerde -> llRojoVerde.setBackgroundColor(Color.GREEN)


            }
        }





       //================================================================
       //   switch
       //================================================================
        swSwitch.setOnClickListener{
            if (swSwitch.isChecked)
                Toast.makeText(this,"Switch ON",Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"Switch OFF",Toast.LENGTH_SHORT).show()
        }
        //=================== toggle button
        tbInterruptor.setOnCheckedChangeListener{ bt, estaSeleccionado ->
            if(estaSeleccionado)
                Toast.makeText(this,"Cambia a seleccionado",Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"Ya no está",Toast.LENGTH_SHORT).show()


        }

    // Barra de progresion
        btIniciarProgresion.setOnClickListener{
            var estadoBarrra =0
            Thread(Runnable {
                while (estadoBarrra<100) {
                    estadoBarrra++
                    try {
                        Thread.sleep(40)
                        pbProgresion.setProgress(estadoBarrra)
                    } catch (exp: InterruptedException) {
                        exp.printStackTrace()
                    }
                }
            }).start()

        }

    }
}
