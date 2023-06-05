package com.example.lab04.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class Country (
    val name_En : String,
    val name_Es : String,
    val continent_En : String,
    val continent_Es : String,
    val capital_En : String,
    val capital_Es : String,
    val dialCode : String,
    val code : String,
    val tld : String,
    val km2 : Int
)