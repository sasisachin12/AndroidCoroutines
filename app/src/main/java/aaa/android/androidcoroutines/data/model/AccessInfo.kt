package aaa.android.androidcoroutines.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AccessInfo(
    @field:Json(name = "accessViewStatus")
    val accessViewStatus: String?= null,
    @JsonClass(generateAdapter = true)
    val country: String?= null,
    @field:Json(name = "embeddable")
    val embeddable: Boolean?= null,
    @field:Json(name = "epub")
    val epub: Epub?= null,
    @field:Json(name = "pdf")
    val pdf: Pdf?= null,
    @field:Json(name = "publicDomain")
    val publicDomain: Boolean?= null,
    @field:Json(name = "quoteSharingAllowed")
    val quoteSharingAllowed: Boolean?= null,
    @field:Json(name = "textToSpeechPermission")
    val textToSpeechPermission: String?= null,
    @field:Json(name = "viewability")
    val viewability: String?= null,
    @field:Json(name = "webReaderLink")
    val webReaderLink: String?= null
)