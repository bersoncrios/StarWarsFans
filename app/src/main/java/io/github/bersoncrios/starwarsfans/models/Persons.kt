package io.github.bersoncrios.starwarsfans.models


import com.google.gson.annotations.SerializedName

data class Persons(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<Result>
)