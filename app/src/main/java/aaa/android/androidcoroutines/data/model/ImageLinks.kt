package aaa.android.androidcoroutines.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageLinks(
    @field:Json(name = "smallThumbnail")
    val smallThumbnail: String?= null,
    @field:Json(name = "thumbnail")
    val thumbnail: String?= null
)