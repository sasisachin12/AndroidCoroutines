package aaa.android.androidcoroutines.data.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(
    @field:Json(name = "accessInfo")
    val accessInfo: AccessInfo?= null,
    @field:Json(name = "etag")
    val etag: String?= null,
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "kind")
    val kind: String?= null,
    @field:Json(name = "saleInfo")
    val saleInfo: SaleInfo?= null,
    @field:Json(name = "searchInfo")
    val searchInfo: SearchInfo?= null,
    @field:Json(name = "selfLink")
    val selfLink: String?= null,
    @field:Json(name = "volumeInfo")
    val volumeInfo: VolumeInfo?= null
)