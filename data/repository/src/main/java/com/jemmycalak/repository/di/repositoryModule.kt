package com.jemmycalak.repository.di


import com.jemmycalak.repository.LigaRepository
import com.jemmycalak.repository.LigaRepositoryListener
import com.jemmycalak.repository.utils.AppDispatchers
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val repositoryModule = module{

    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
    factory { LigaRepository(get(), get()) as LigaRepositoryListener }
}