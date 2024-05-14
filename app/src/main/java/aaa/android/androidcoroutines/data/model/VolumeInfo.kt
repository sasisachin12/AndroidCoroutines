package aaa.android.androidcoroutines.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VolumeInfo(
    @field:Json(name = "allowAnonLogging")
    val allowAnonLogging: Boolean?= null,
    @field:Json(name = "authors")
    val authors: List<String>?= null,
    @field:Json(name = "averageRating")
    val averageRating: Int?= null,
    @field:Json(name = "canonicalVolumeLink")
    val canonicalVolumeLink: String?= null,
    @field:Json(name = "categories")
    val categories: List<String>?= null,
    @field:Json(name = "contentVersion")
    val contentVersion: String?= null,
    @field:Json(name = "description")
    val description: String?= null,
    @field:Json(name = "imageLinks")
    val imageLinks: ImageLinks?= null,
    @field:Json(name = "industryIdentifiers")
    val industryIdentifiers: List<IndustryIdentifier>?= null,
    @field:Json(name = "infoLink")
    val infoLink: String?= null,
    @field:Json(name = "language")
    val language: String?= null,
    @field:Json(name = "maturityRating")
    val maturityRating: String?= null,
    @field:Json(name = "pageCount")
    val pageCount: Int?= null,
    @field:Json(name = "panelizationSummary")
    val panelizationSummary: PanelizationSummary?= null,
    @field:Json(name = "previewLink")
    val previewLink: String?= null,
    @field:Json(name = "textSnippet")
    val printType: String?= null,
    @field:Json(name = "publishedDate")
    val publishedDate: String?= null,
    @field:Json(name = "publisher")
    val publisher: String?= null,
    @field:Json(name = "ratingsCount")
    val ratingsCount: Int?= null,
    @field:Json(name = "readingModes")
    val readingModes: ReadingModes?= null,
    @field:Json(name = "subtitle")
    val subtitle: String?= null,
    @field:Json(name = "title")
    val title: String?= null
)