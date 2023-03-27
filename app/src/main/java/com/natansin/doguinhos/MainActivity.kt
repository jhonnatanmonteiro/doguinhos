package com.natansin.doguinhos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import coil.load
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getImageButton.setOnClickListener {
            //Iniciar o usuário e passar Dispatchers.Main para informar que o resultado
            // desta Coroutine é esperado no thread principal
            launch(Dispatchers.Main) {

              //Tente o bloco catch para lidar com excecoes ao chamar a API dos catiorros
                try {
                    val response = catioroAdapter.apiClient.getRandomImage()
                    //Verifica se a resposta foi bem sucedida
                    if (response.isSuccessful && response.body() != null) {
                        val data = response.body()!!
                        //Verifica nulo
                        data.message?.let { imageUrl ->
                            //Carregar URL no ImageView usando Coil
                            dogImageView.load(imageUrl)
                        }
                    } else {
                        // mostra erro na api
                        Toast.makeText(
                            this@MainActivity,
                            "error de servidor", Toast.LENGTH_LONG
                        ).show()
                    }
                } catch (e: Exception) {
                    //mostra errro de api gerado pelo client
                    Toast.makeText(
                        this@MainActivity, "error de internet",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

    }

}
