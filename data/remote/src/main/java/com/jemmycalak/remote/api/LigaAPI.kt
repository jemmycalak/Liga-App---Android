package com.jemmycalak.remote.api

import com.jemmycalak.model.LigaModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface LigaAPI {

    @GET("search_all_leagues.php")
    suspend fun getDataLiga(@QueryMap query:HashMap<String, Any>):Response<LigaModel>
}