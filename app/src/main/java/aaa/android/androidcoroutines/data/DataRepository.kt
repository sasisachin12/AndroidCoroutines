package aaa.android.androidcoroutines.data

import aaa.android.androidcoroutines.data.model.Item
import aaa.android.androidcoroutines.di.ApiService
import aaa.android.androidcoroutines.utils.AppConst
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL
import javax.inject.Inject
import aaa.android.androidcoroutines.di.modules.ApplicationScope
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