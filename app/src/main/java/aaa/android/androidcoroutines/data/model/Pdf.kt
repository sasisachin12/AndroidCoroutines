package aaa.android.androidcoroutines.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Pdf(
    @field:Json(name = "acsTokenLink")
    val acsTokenLink: String?= null,
    @field:Json(name = "isAvailable")
    val isAvailable: Boolean?= null
)