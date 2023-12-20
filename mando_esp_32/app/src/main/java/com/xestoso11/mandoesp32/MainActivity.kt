package com.xestoso11.mandoesp32

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import android.widget.Toast


//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//}
@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickButton(view: View) {
        //HttpRequestTask().execute("http://192.168.0.110")
        when (view.id) {
            R.id.perso -> HttpRequestTask("http://192.168.0.110/Perso").execute()
            R.id.serv -> HttpRequestTask("http://192.168.0.110/Serv").execute()
            R.id.m -> HttpRequestTask("http://192.168.0.110/M").execute()
            R.id.grabar -> HttpRequestTask("http://192.168.0.110/Grabar").execute()
            R.id.live -> HttpRequestTask("http://192.168.0.110/live").execute()
            R.id.play -> HttpRequestTask("http://192.168.0.110/play").execute()
            R.id.pausa -> HttpRequestTask("http://192.168.0.110/pausa").execute()
            R.id.adelante -> HttpRequestTask("http://192.168.0.110/adelante").execute()
            R.id.atras -> HttpRequestTask("http://192.168.0.110/atras").execute()
            R.id.b -> HttpRequestTask("http://192.168.0.110/0").execute()
            R.id.b1 -> HttpRequestTask("http://192.168.0.110/1").execute()
            R.id.b2 -> HttpRequestTask("http://192.168.0.110/2").execute()
            R.id.b3 -> HttpRequestTask("http://192.168.0.110/3").execute()
            R.id.b4 -> HttpRequestTask("http://192.168.0.110/4").execute()
            R.id.b5 -> HttpRequestTask("http://192.168.0.110/5").execute()
            R.id.b6 -> HttpRequestTask("http://192.168.0.110/6").execute()
            R.id.b7 -> HttpRequestTask("http://192.168.0.110/7").execute()
            R.id.b8 -> HttpRequestTask("http://192.168.0.110/8").execute()
            R.id.b9 -> HttpRequestTask("http://192.168.0.110/9").execute()
            R.id.pmas -> HttpRequestTask("http://192.168.0.110/P+").execute()
            R.id.pmenos -> HttpRequestTask("http://192.168.0.110/P-").execute()
            R.id.vmas -> HttpRequestTask("http://192.168.0.110/VOL+").execute()
            R.id.vmenos -> HttpRequestTask("http://192.168.0.110/VOL-").execute()

            R.id.ok -> HttpRequestTask("http://192.168.0.110/OK").execute()
            R.id.derecha -> HttpRequestTask("http://192.168.0.110/DERECHA").execute()
            R.id.izquierda -> HttpRequestTask("http://192.168.0.110/IZQUIERDA").execute()
            R.id.arriba -> HttpRequestTask("http://192.168.0.110/ARRIBA").execute()
            R.id.abajo -> HttpRequestTask("http://192.168.0.110/ABAJO").execute()
            R.id.guia -> HttpRequestTask("http://192.168.0.110/MENU").execute()
            R.id.piloto -> HttpRequestTask("http://192.168.0.110/Piloto").execute()
            R.id.micanal -> HttpRequestTask("http://192.168.0.110/micanal").execute()
            R.id.volver -> HttpRequestTask("http://192.168.0.110/Volver").execute()
            R.id.salir -> HttpRequestTask("http://192.168.0.110/EXIT").execute()

            // Puedes agregar más botones y direcciones IP según sea necesario
        }
    }
    private inner class HttpRequestTask(private val url: String) : AsyncTask<Void, Void, String>() {

    //private inner class HttpRequestTask : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg params: Void): String {

        //override fun doInBackground(vararg params: String): String {
            try {
                val url = URL(url)
                val urlConnection = url.openConnection() as HttpURLConnection
                try {
                    val `in`: InputStream = urlConnection.inputStream
                    val reader = BufferedReader(InputStreamReader(`in`))
                    val result = StringBuilder()
                    var line: String?
                    while (reader.readLine().also { line = it } != null) {
                        result.append(line)
                    }
                    return result.toString()
                } finally {
                    urlConnection.disconnect()
                }
            } catch (e: IOException) {
                return "Error: ${e.message}"
            }
        }
        //override fun onPostExecute(result: String) {
            // Manejar la respuesta del servidor como desees
        //    showToast(result)
        //}


    private fun showToast(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
//        override fun onPostExecute(result: String) {
//            Toast.makeText(this@MainActivity, result, Toast.LENGTH_SHORT).show()
        // Aquí puedes manejar la respuesta del servidor como lo desees
    }
}

