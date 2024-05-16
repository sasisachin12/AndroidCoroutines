package aaa.android.androidcoroutines.data

import aaa.android.androidcoroutines.data.model.BookItem
import aaa.android.androidcoroutines.di.ApiService
import aaa.android.androidcoroutines.di.modules.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val apiService: ApiService,
    @ApplicationScope private val ioScope: CoroutineScope
) {


    suspend fun getBookList(searchText:String): List<BookItem>? {
        return withContext(ioScope.coroutineContext) {
            apiService.getBookList(searchText).items
        }
    }
}