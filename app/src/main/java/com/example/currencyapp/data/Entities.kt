package com.example.currencyapp.data

data class CurrencyValueResponse(val info: InfoItem) {
    data class InfoItem (val rate: Double)
}