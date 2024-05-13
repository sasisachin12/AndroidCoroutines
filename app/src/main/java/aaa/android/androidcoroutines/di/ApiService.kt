package aaa.android.androidcoroutines.di

import aaa.android.androidcoroutines.data.model.BooKListData
import aaa.android.androidcoroutines.data.model.LoginResponse
import retrofit2.http.GET

interface ApiService {

    @GET("DisneyPosters2.json")
    suspend fun getBookList(): aaa.android.androidcoroutines.data.Result<BooKListData>
}