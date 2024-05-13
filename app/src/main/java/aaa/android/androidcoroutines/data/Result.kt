package aaa.android.androidcoroutines.data

sealed class Result<T>(val data: T? = null, val message: String? = null) {
    class Loading<T> : Result<T>()
    data class Success<T>(val resultsData: T) : Result<T>(resultsData)
    class Error<T>(message: String, data: T? = null) : Result<T>(data, message)
}
