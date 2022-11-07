package br.com.alura.ceep.webclient

import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.model.NotaRequisicao
import br.com.alura.ceep.webclient.service.NotaServices

class NotaWebClient {

    private val notaServices: NotaServices = RetrofitInicializador().notaService

    suspend fun buscaTodas(): List<Nota>? {
        return try {
            val notasResposta = notaServices
                .buscaTodas()
            notasResposta.map { notaResposta ->
                notaResposta.nota
            }
        } catch (e: Exception) {
            null
        }
    }

    suspend fun salva(nota: Nota) : Boolean {
        try {
            val resposta = notaServices.salva(
                nota.id,
                NotaRequisicao(
                    titulo = nota.titulo,
                    descricao = nota.descricao,
                    imagem = nota.imagem
                )
            )
            return resposta.isSuccessful
        } catch (e: Exception) {

        }
        return false
    }

    suspend fun remove(id: String): Boolean {
        try {
            val resposta = notaServices.remove(id)
            return resposta.isSuccessful
        } catch (e: Exception) {

        }
        return false
    }

}