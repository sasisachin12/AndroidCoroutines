package aaa.android.androidcoroutines.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BooKListData(
    @field:Json(name = "items")
    val items: List<Item>?= null,
    @field:Json(name = "kind")
    val kind: String?= null,
    @field:Json(name = "totalItems")
    val totalItems: Int?= null
)