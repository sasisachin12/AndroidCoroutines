package aaa.android.androidcoroutines.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CoroutinesScopesModule {

	@Singleton
	@ApplicationScope
	@Provides
	fun providesIoCoroutineScope(
		@IoDispatcher ioDispatcher: CoroutineDispatcher
	): CoroutineScope = CoroutineScope(ioDispatcher)
}
