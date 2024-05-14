package aaa.android.androidcoroutines.di.modules

import aaa.android.androidcoroutines.data.DataRepository
import aaa.android.androidcoroutines.di.ApiService
import aaa.android.androidcoroutines.utils.AppConst
import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun providesRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return Retrofit.Builder().client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(AppConst.BOOK_BASE_URL).build()
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(
        customInterceptor: CustomInterceptor
    ): OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor(customInterceptor)
            .connectTimeout(10, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS)
            .callTimeout(10, TimeUnit.SECONDS).retryOnConnectionFailure(true).build()
    }

    @Singleton
    @Provides
    fun providesInterceptor(@ApplicationContext context: Context) = CustomInterceptor(context)

    @Singleton
    @Provides
    fun providesAPIService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)


    @Singleton
    @Provides
    fun providesDataRepository(apiService: ApiService, @ApplicationScope ioScope: CoroutineScope) =
        DataRepository(apiService, ioScope)
}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthInterceptorOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OtherInterceptorOkHttpClient


@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class DefaultDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class IoDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class MainDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainImmediateDispatcher
