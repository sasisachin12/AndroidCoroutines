package aaa.android.androidcoroutines.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IndustryIdentifier(
    @field:Json(name = "identifier")
    val identifier: String?= null,
    @field:Json(name = "type")
    val type: String?= null
)