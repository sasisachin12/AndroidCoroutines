package aaa.android.androidcoroutines.di

import aaa.android.androidcoroutines.data.model.BooKListData
import aaa.android.androidcoroutines.utils.AppConst.BOOK_GET_LIST
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(BOOK_GET_LIST)
    suspend fun getBookList(@Query("q") q: String): BooKListData
}