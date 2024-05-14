package aaa.android.androidcoroutines.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ListPrice(
    @field:Json(name = "amount")
    val amount: Double?= null,
    @field:Json(name = "currencyCode")
    val currencyCode: String?= null
)