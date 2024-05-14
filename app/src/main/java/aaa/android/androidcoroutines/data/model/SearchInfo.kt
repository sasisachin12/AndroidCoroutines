package aaa.android.androidcoroutines.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchInfo(
    @field:Json(name = "textSnippet")
    val textSnippet: String?= null
)