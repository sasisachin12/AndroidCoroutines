package aaa.android.androidcoroutines.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Offer(
    @field:Json(name = "finskyOfferType")
    val finskyOfferType: Int?= null,
    @field:Json(name = "listPrice")
    val listPrice: ListPriceX?= null,
    @field:Json(name = "retailPrice")
    val retailPrice: RetailPrice?= null
)