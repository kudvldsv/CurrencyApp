package com.example.currencyapp.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenCurrencyValueApi {

    @GET("convert?")
    fun getCurrentExchange(
        @Query("from") firstValue:String,
        @Query("to") secondValue: String = "RUB"
    ): Call<CurrencyValueResponse>

}