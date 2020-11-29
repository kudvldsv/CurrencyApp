package com.example.currencyapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.currencyapp.R
import com.example.currencyapp.data.ExchangeRepo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), CoroutineScope {
    override val coroutineContext = Dispatchers.Main
    private val repository = ExchangeRepo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launch {
            val usd = repository.getCurrentExchangeForUsd()
            usd?.apply {
                usdValue.text = getString(R.string.usd_format).format(info.rate)
            }
            val eur = repository.getCurrentExchangeForEur()
            eur?.apply {
                eurValue.text = getString(R.string.eur_format).format(info.rate)
            }
            val btc = repository.getCurrentExchangeForBtc()
            btc?.apply {
                btcValue.text = getString(R.string.btc_format).format(info.rate)
            }
        }
    }


}