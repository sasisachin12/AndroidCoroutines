package aaa.android.androidcoroutines.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RetailPrice(
    @field:Json(name = "amountInMicros")
    val amountInMicros: Long?= null,
    @field:Json(name = "currencyCode")
    val currencyCode: String?= null
)