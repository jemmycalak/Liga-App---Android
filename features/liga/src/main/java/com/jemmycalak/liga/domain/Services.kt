package com.jemmycalak.liga.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.jemmycalak.model.LigaModel
import com.jemmycalak.repository.LigaRepositoryListener
import com.jemmycalak.repository.utils.Resource

class Services(val liga: LigaRepositoryListener) {

    suspend operator fun invoke(q:String, shouldFetch:Boolean) : LiveData<Resource<LigaModel>> =
        Transformations.map(liga.getDataLiga(q, shouldFetch)){it}
}