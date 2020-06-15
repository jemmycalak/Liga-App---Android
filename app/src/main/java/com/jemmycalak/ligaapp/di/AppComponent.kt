package com.jemmycalak.ligaapp.di

import com.jemmycalak.liga.di.ligaModule
import com.jemmycalak.ligaapp.BuildConfig
import com.jemmycalak.remote.di.remoteModule
import com.jemmycalak.repository.di.repositoryModule
import org.koin.core.module.Module


val appComponent : List<Module> = listOf(
    remoteModule(BuildConfig.BASE_URL),
    repositoryModule,
    ligaModule
)