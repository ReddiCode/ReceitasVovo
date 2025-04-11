package com.redditizie.receitasvovo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize // Usando o parcelize...apos adicionar a linha no build.gradle(module)
data class Receita(

    val titulo: String,
    val tempo: String,
    val idImagem: Int,
    val ingredientes: List<String>

) : Parcelable


// Usando Serializable

/*data class Receita(

    val titulo: String,
    val tempo: String,
    val idImagem: Int

) : Serializable*/
