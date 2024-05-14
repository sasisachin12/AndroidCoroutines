package aaa.android.androidcoroutines.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PanelizationSummary(
    @field:Json(name = "containsEpubBubbles")
    val containsEpubBubbles: Boolean?= null,
    @field:Json(name = "containsImageBubbles")
    val containsImageBubbles: Boolean?= null
)