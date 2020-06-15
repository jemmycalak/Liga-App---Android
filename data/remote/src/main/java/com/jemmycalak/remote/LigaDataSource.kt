package com.jemmycalak.remote


import com.jemmycalak.model.LigaModel
import com.jemmycalak.remote.api.LigaAPI
import com.jemmycalak.remote.utils.Constants as k
import retrofit2.Response

class LigaDataSource(val api:LigaAPI) {

    suspend fun getDataLiga(country:String):Response<LigaModel> {
        val queryMap = HashMap<String, Any>()
        queryMap[k.query] = country
        return api.getDataLiga(queryMap)
    }
}