package com.jemmycalak.repository


import androidx.lifecycle.LiveData
import com.google.gson.Gson
import com.jemmycalak.model.LigaModel
import com.jemmycalak.remote.LigaDataSource
import com.jemmycalak.repository.utils.NetworkResource
import com.jemmycalak.repository.utils.Resource
import retrofit2.Response

interface LigaRepositoryListener{
    suspend fun getDataLiga(q:String, shouldFetch:Boolean):LiveData<Resource<LigaModel>>
}

class LigaRepository(
    val dataSource : LigaDataSource,
    val gson:Gson
):LigaRepositoryListener {
    override suspend fun getDataLiga(q:String, shouldFetch:Boolean): LiveData<Resource<LigaModel>> {
        return object : NetworkResource<LigaModel, LigaModel>(gson){

            override fun processResponse(response: LigaModel): LigaModel = response

            override suspend fun createCallAsync(): Response<LigaModel> = dataSource.getDataLiga(q)

        }.build().asLiveData()
    }
}