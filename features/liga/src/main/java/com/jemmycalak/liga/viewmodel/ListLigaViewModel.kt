package com.jemmycalak.liga.viewmodel

import androidx.lifecycle.*
import com.jemmycalak.liga.domain.Services
import com.jemmycalak.model.LigaModel
import com.jemmycalak.repository.utils.AppDispatchers
import com.jemmycalak.repository.utils.Resource
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListLigaViewModel(
    private val dispatchers: AppDispatchers,
    private val service: Services
) : ViewModel() {

    private val _ligaMediator = MediatorLiveData<Resource<LigaModel>>()
    private var ligaResource: LiveData<Resource<LigaModel>> = MutableLiveData<Resource<LigaModel>>()
    val dataRepository: LiveData<Resource<LigaModel>> get() = _ligaMediator

    fun getDataLiga(q:String){
        viewModelScope.launch(dispatchers.main) {
            _ligaMediator.removeSource(ligaResource)
            withContext(dispatchers.io) {
                ligaResource = service(q, true)
            }
            _ligaMediator.addSource(ligaResource) {
                _ligaMediator.postValue(it)
            }
        }
    }
}