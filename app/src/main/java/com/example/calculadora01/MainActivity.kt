package com.example.calculadora01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var numero =0
    var punto=true
    var negativo=true
    var nueva_operacion=true
    var num_anterior="0"
    var operador="+"

    fun pressNum(view: View) {
        var texto_pantalla:String = textView2.text.toString()
        val btn = view as Button
        print("Numero 1")
        when(btn.id){
            button1.id -> {
                if(textView2.text == "0" ){
                    texto_pantalla = "1"
                }else{
                    texto_pantalla += "1"
                }
            }
            button2.id -> {
                if(textView2.text == "0" ){
                    texto_pantalla = "2"
                }else{
                    texto_pantalla += "2"
                }
            }
            button3.id -> {
                if(textView2.text == "0" ){
                    texto_pantalla = "3"
                }else{
                    texto_pantalla += "3"
                }
            }
            button4.id -> {
                if(textView2.text == "0" ){
                    texto_pantalla = "4"
                }else{
                    texto_pantalla += "4"
                }
            }
            button5.id -> {
                if(textView2.text == "0" ){
                    texto_pantalla = "5"
                }else{
                    texto_pantalla += "5"
                }
            }
            button6.id -> {
                if(textView2.text == "0" ){
                    texto_pantalla = "6"
                }else{
                    texto_pantalla += "6"
                }
            }
            button7.id -> {
                if(textView2.text == "0" ){
                    texto_pantalla = "7"
                }else{
                    texto_pantalla += "7"
                }
            }
            button8.id -> {
                if(textView2.text == "0" ){
                    texto_pantalla = "8"
                }else{
                    texto_pantalla += "8"
                }
            }
            button9.id -> {
                if(textView2.text == "0" ){
                    texto_pantalla = "9"
                }else{
                    texto_pantalla += "9"
                }
            }
            button0.id -> {
                if(textView2.text == "0" ){

                }else{
                    texto_pantalla +="0"
                }
            }
            buttonPoint.id -> {
                if(punto){
                    texto_pantalla +="."
                    punto=false
                }
            }
            buttonPM.id -> {
                if(negativo){
                    if (textView2.text == "0"){
                        texto_pantalla = "-"
                    }else{
                        texto_pantalla = "-$texto_pantalla"
                    }
                    negativo=false
                }
            }
            buttonAC.id->{
                num_anterior="0"
                texto_pantalla="0"
                punto=true
                negativo=true
            }

        }
        textView2.setText(texto_pantalla)
    }

    fun operacion(view: View) {
        nueva_operacion=true
        num_anterior=textView2.text.toString()
        val btn = view as Button
        when(btn.id){
            buttonPlus.id -> {operador="+"}
            buttonMin.id -> {operador="-"}
            buttonX.id -> {operador="*"}
            buttonDiv.id -> {operador="/"}
        }
        textView2.text="0"
        punto=true
        negativo=true
    }

    fun resultado(view: View) {
        var numero_nuevo:String = textView2.text.toString()
        val btn=view as Button
        var total=0.0
        when(btn.id){
            buttonEqual.id->{
                when(operador){
                    "+"->{total=num_anterior.toDouble() + numero_nuevo.toDouble()}
                    "-"->{total=num_anterior.toDouble() - numero_nuevo.toDouble()}
                    "*"->{total=num_anterior.toDouble() * numero_nuevo.toDouble()}
                    "/"->{total=num_anterior.toDouble() / numero_nuevo.toDouble()}
                }
            }
            button100.id->{
                when(operador){
                    "+"->{total=num_anterior.toDouble() + (numero_nuevo.toDouble() / 100)}
                    "-"->{total=num_anterior.toDouble() - (numero_nuevo.toDouble() / 100)}
                    "*"->{total=num_anterior.toDouble() * (numero_nuevo.toDouble() / 100)}
                    "/"->{total=num_anterior.toDouble() / (numero_nuevo.toDouble() / 100)}
                }
            }
        }
        textView2.setText(total.toString())

    }


}