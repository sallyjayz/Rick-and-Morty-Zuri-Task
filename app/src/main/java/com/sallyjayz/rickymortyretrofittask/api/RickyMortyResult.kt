package com.sallyjayz.rickymortyretrofittask.api

import com.squareup.moshi.Json

data class RickyMortyResult (
    @Json(name="id")
    val id: Int,
    @Json(name="name")
    val characterName: String,
    @Json(name="status")
    val characterStatus: String,
    @Json(name="species")
    val characterSpecie: String,
    @Json(name="image")
    val characterImage: String,
)
