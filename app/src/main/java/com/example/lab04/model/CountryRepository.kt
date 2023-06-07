package com.example.lab04.model

import com.example.lab04.entities.Country
import com.google.gson.Gson

class CountryRepository {

    fun getCountries(){
        val jsonData = "raw/countries.json"  // res/raw/countries.json
        val countriesFromJson = Gson().fromJson(jsonData, Array<Country>::class.java).toList()
    }

}