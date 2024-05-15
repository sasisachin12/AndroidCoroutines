package aaa.android.androidcoroutines.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(
    @field:Json(name = "accessInfo")
    val accessInfo: AccessInfo? = null,
    @field:Json(name = "etag")
    val etag: String? = null,
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "kind")
    val kind: String? = null,
    @field:Json(name = "saleInfo")
    val saleInfo: SaleInfo? = null,
    @field:Json(name = "searchInfo")
    val searchInfo: SearchInfo? = null,
    @field:Json(name = "selfLink")
    val selfLink: String? = null,
    @field:Json(name = "volumeInfo")
    val volumeInfo: VolumeInfo? = null
)

@JsonClass(generateAdapter = true)
data class AccessInfo(
    @field:Json(name = "accessViewStatus")
    val accessViewStatus: String? = null,
    @JsonClass(generateAdapter = true)
    val country: String? = null,
    @field:Json(name = "embeddable")
    val embeddable: Boolean? = null,
    @field:Json(name = "epub")
    val epub: Epub? = null,
    @field:Json(name = "pdf")
    val pdf: Pdf? = null,
    @field:Json(name = "publicDomain")
    val publicDomain: Boolean? = null,
    @field:Json(name = "quoteSharingAllowed")
    val quoteSharingAllowed: Boolean? = null,
    @field:Json(name = "textToSpeechPermission")
    val textToSpeechPermission: String? = null,
    @field:Json(name = "viewability")
    val viewability: String? = null,
    @field:Json(name = "webReaderLink")
    val webReaderLink: String? = null
)

@JsonClass(generateAdapter = true)
data class BooKListData(
    @field:Json(name = "items")
    val items: List<Item>? = null,
    @field:Json(name = "kind")
    val kind: String? = null,
    @field:Json(name = "totalItems")
    val totalItems: Int? = null
)


@JsonClass(generateAdapter = true)
data class Epub(
    @field:Json(name = "acsTokenLink")
    val acsTokenLink: String? = null,
    @field:Json(name = "isAvailable")
    val isAvailable: Boolean? = null
)

@JsonClass(generateAdapter = true)
data class ImageLinks(
    @field:Json(name = "smallThumbnail")
    val smallThumbnail: String? = null,
    @field:Json(name = "thumbnail")
    val thumbnail: String? = null
)

@JsonClass(generateAdapter = true)
data class IndustryIdentifier(
    @field:Json(name = "identifier")
    val identifier: String? = null,
    @field:Json(name = "type")
    val type: String? = null
)

@JsonClass(generateAdapter = true)
data class ListPrice(
    @field:Json(name = "amount")
    val amount: Double? = null,
    @field:Json(name = "currencyCode")
    val currencyCode: String? = null
)

@JsonClass(generateAdapter = true)
data class ListPriceX(
    @field:Json(name = "amountInMicros")
    val amountInMicros: Long? = null,
    @field:Json(name = "currencyCode")
    val currencyCode: String? = null
)

@JsonClass(generateAdapter = true)
data class Offer(
    @field:Json(name = "finskyOfferType")
    val finskyOfferType: Int? = null,
    @field:Json(name = "listPrice")
    val listPrice: ListPriceX? = null,
    @field:Json(name = "retailPrice")
    val retailPrice: RetailPrice? = null
)

@JsonClass(generateAdapter = true)
data class PanelizationSummary(
    @field:Json(name = "containsEpubBubbles")
    val containsEpubBubbles: Boolean? = null,
    @field:Json(name = "containsImageBubbles")
    val containsImageBubbles: Boolean? = null
)

@JsonClass(generateAdapter = true)
data class Pdf(
    @field:Json(name = "acsTokenLink")
    val acsTokenLink: String? = null,
    @field:Json(name = "isAvailable")
    val isAvailable: Boolean? = null
)

@JsonClass(generateAdapter = true)
data class ReadingModes(
    @field:Json(name = "image")
    val image: Boolean? = null,
    @field:Json(name = "text")
    val text: Boolean? = null
)

@JsonClass(generateAdapter = true)
data class RetailPrice(
    @field:Json(name = "amountInMicros")
    val amountInMicros: Long? = null,
    @field:Json(name = "currencyCode")
    val currencyCode: String? = null
)

@JsonClass(generateAdapter = true)
data class RetailPriceX(
    @field:Json(name = "amount")
    val amount: Double? = null,
    @field:Json(name = "currencyCode")
    val currencyCode: String? = null
)

@JsonClass(generateAdapter = true)
data class SaleInfo(
    @field:Json(name = "buyLink")
    val buyLink: String? = null,
    @field:Json(name = "country")
    val country: String? = null,
    @field:Json(name = "isEbook")
    val isEbook: Boolean? = null,
    @field:Json(name = "listPrice")
    val listPrice: ListPrice? = null,
    @field:Json(name = "offers")
    val offers: List<Offer>? = null,
    @field:Json(name = "retailPrice")
    val retailPrice: RetailPriceX? = null,
    @field:Json(name = "saleability")
    val saleability: String? = null
)

@JsonClass(generateAdapter = true)
data class SearchInfo(
    @field:Json(name = "textSnippet")
    val textSnippet: String? = null
)

@JsonClass(generateAdapter = true)
data class VolumeInfo(
    @field:Json(name = "allowAnonLogging")
    val allowAnonLogging: Boolean? = null,
    @field:Json(name = "authors")
    val authors: List<String>? = null,
    @field:Json(name = "averageRating")
    val averageRating: Int? = null,
    @field:Json(name = "canonicalVolumeLink")
    val canonicalVolumeLink: String? = null,
    @field:Json(name = "categories")
    val categories: List<String>? = null,
    @field:Json(name = "contentVersion")
    val contentVersion: String? = null,
    @field:Json(name = "description")
    val description: String? = null,
    @field:Json(name = "imageLinks")
    val imageLinks: ImageLinks? = null,
    @field:Json(name = "industryIdentifiers")
    val industryIdentifiers: List<IndustryIdentifier>? = null,
    @field:Json(name = "infoLink")
    val infoLink: String? = null,
    @field:Json(name = "language")
    val language: String? = null,
    @field:Json(name = "maturityRating")
    val maturityRating: String? = null,
    @field:Json(name = "pageCount")
    val pageCount: Int? = null,
    @field:Json(name = "panelizationSummary")
    val panelizationSummary: PanelizationSummary? = null,
    @field:Json(name = "previewLink")
    val previewLink: String? = null,
    @field:Json(name = "textSnippet")
    val printType: String? = null,
    @field:Json(name = "publishedDate")
    val publishedDate: String? = null,
    @field:Json(name = "publisher")
    val publisher: String? = null,
    @field:Json(name = "ratingsCount")
    val ratingsCount: Int? = null,
    @field:Json(name = "readingModes")
    val readingModes: ReadingModes? = null,
    @field:Json(name = "subtitle")
    val subtitle: String? = null,
    @field:Json(name = "title")
    val title: String? = null
)