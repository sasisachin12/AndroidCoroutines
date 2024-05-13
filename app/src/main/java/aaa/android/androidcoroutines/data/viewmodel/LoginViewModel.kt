package aaa.android.androidcoroutines.data.viewmodel

import aaa.android.androidcoroutines.data.DataRepository
import aaa.android.androidcoroutines.data.model.Item
import aaa.android.androidcoroutines.data.model.LoginResponse
import aaa.android.androidcoroutines.di.modules.ApplicationScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: DataRepository,
    @ApplicationScope private var ioScope: CoroutineScope
) : ViewModel() {

    fun getBookLists() {
        val _articlesListLiveData =
            MutableLiveData<aaa.android.androidcoroutines.data.Result<List<Item>?>>()
        val articlesListLiveData: LiveData<aaa.android.androidcoroutines.data.Result<List<Item>?>> =
            _articlesListLiveData

        suspend fun fetchArticlesList() {

            _articlesListLiveData.apply {
                postValue(aaa.android.androidcoroutines.data.Result.Loading())
            }

            val exceptionHandler = CoroutineExceptionHandler { _, exception ->
                _articlesListLiveData.apply {
                    postValue(
                        exception.message?.let {
                            aaa.android.androidcoroutines.data.Result.Error(it)
                        }
                    )
                }
            }

            viewModelScope.launch(ioScope.coroutineContext + exceptionHandler) {
                val results = repository.getBookList()
                _articlesListLiveData.apply {
                    postValue(aaa.android.androidcoroutines.data.Result.Success(results))
                }
            }
        }
    }
}