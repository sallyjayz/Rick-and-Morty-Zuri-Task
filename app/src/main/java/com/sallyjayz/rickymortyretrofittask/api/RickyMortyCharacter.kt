package com.sallyjayz.rickymortyretrofittask.api

import com.squareup.moshi.Json

data class RickyMortyCharacter (
    @Json(name="results")
    val results:List<RickyMortyResult>,
)