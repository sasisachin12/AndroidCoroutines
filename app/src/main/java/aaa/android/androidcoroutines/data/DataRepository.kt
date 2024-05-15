package aaa.android.androidcoroutines.data

import aaa.android.androidcoroutines.data.model.Item
import aaa.android.androidcoroutines.di.ApiService
import aaa.android.androidcoroutines.di.modules.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val apiService: ApiService,
    @ApplicationScope private val ioScope: CoroutineScope
) {


    suspend fun getBookList(searchText:String): List<Item>? {
        return withContext(ioScope.coroutineContext) {
            apiService.getBookList(searchText).items
        }
    }
}