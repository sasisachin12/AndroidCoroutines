package aaa.android.androidcoroutines.data.viewmodel

import aaa.android.androidcoroutines.data.DataRepository
import aaa.android.androidcoroutines.data.ResponseData
import aaa.android.androidcoroutines.data.model.BookItem
import aaa.android.androidcoroutines.di.modules.ApplicationScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
class BookViewModel @Inject constructor(
    private val repository: DataRepository,
    @ApplicationScope private var ioScope: CoroutineScope
) : ViewModel() {
    private val _articlesListLiveData =
        MutableLiveData<ResponseData<List<BookItem>?>>()
    val articlesListLiveData: LiveData<ResponseData<List<BookItem>?>> =
        _articlesListLiveData

    val categoryList = mutableStateListOf<BookItem>()

    var searchDisplayValue by mutableStateOf("")


    fun setSearchText(value: String) {
        searchDisplayValue = value
    }


    suspend fun getBookLists(searchText: String) {


        _articlesListLiveData.apply {
            postValue(ResponseData.Loading())
        }

        val exceptionHandler = CoroutineExceptionHandler { _, exception ->
            _articlesListLiveData.apply {
                postValue(
                    exception.message?.let {
                        ResponseData.Error(it)
                    }
                )
            }
        }
        try {
            viewModelScope.launch(ioScope.coroutineContext + exceptionHandler) {
                val results = repository.getBookList(searchText)
                results?.toMutableList()?.let {
                    categoryList.clear()
                    categoryList.addAll(it)
                }
                _articlesListLiveData.apply {
                    postValue(ResponseData.Success(results))

                }
            }
        } catch (e: Exception) {
             val message=e.message.toString()
             val message1=e.message.toString()
        }
    }

}