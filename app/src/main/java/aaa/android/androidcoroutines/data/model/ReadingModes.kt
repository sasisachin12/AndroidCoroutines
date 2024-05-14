package aaa.android.androidcoroutines.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReadingModes(
    @field:Json(name = "image")
    val image: Boolean?= null,
    @field:Json(name = "text")
    val text: Boolean?= null
)