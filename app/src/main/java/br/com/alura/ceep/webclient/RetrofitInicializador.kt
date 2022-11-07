package br.com.alura.ceep.webclient

import br.com.alura.ceep.webclient.service.NotaServices
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInicializador {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.0.30:8080/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val notaService = retrofit.create(NotaServices::class.java)

}