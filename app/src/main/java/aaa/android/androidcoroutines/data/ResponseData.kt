package aaa.android.androidcoroutines.data

sealed class ResponseData<T>(val data: T? = null, val message: String? = null) {
    class Loading<T> : ResponseData<T>()
    data class Success<T>(val resultsData: T) : ResponseData<T>(resultsData)
    class Error<T>(message: String, data: T? = null) : ResponseData<T>(data, message)
}
