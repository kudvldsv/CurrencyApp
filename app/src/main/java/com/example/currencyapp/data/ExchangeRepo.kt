package com.example.currencyapp.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ExchangeRepo {

    private val coroutineContext = Dispatchers.IO
    private val openCurrencyValueApi = Retrofit.Builder()
        .baseUrl("https://api.exchangerate.host/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(OpenCurrencyValueApi::class.java)

    suspend fun getCurrentExchangeForUsd() = withContext(coroutineContext) {
        openCurrencyValueApi.getCurrentExchange(firstValue = "USD")
            .execute()
            .body()
    }

    suspend fun getCurrentExchangeForEur() = withContext(coroutineContext) {
        openCurrencyValueApi.getCurrentExchange(firstValue = "EUR")
            .execute()
            .body()
    }

    suspend fun getCurrentExchangeForBtc() = withContext(coroutineContext) {
        openCurrencyValueApi.getCurrentExchange(firstValue = "BTC")
            .execute()
            .body()

    }
}