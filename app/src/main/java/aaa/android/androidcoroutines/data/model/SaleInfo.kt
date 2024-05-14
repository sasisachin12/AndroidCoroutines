package aaa.android.androidcoroutines.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SaleInfo(
    @field:Json(name = "buyLink")
    val buyLink: String?= null,
    @field:Json(name = "country")
    val country: String?= null,
    @field:Json(name = "isEbook")
    val isEbook: Boolean?= null,
    @field:Json(name = "listPrice")
    val listPrice: ListPrice?= null,
    @field:Json(name = "offers")
    val offers: List<Offer>?= null,
    @field:Json(name = "retailPrice")
    val retailPrice: RetailPriceX?= null,
    @field:Json(name = "saleability")
    val saleability: String?= null
)