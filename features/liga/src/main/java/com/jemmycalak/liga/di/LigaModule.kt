package com.jemmycalak.liga.di


import com.jemmycalak.liga.domain.Services
import com.jemmycalak.liga.viewmodel.ListLigaViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ligaModule = module{
    factory { Services(get()) }

    viewModel { ListLigaViewModel(get(), get()) }
}