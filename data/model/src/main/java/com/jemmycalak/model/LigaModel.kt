package com.jemmycalak.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LigaModel(
    @SerializedName("countrys")
    val countrys: List<Country>?
) : Serializable