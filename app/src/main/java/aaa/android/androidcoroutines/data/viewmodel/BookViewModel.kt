package aaa.android.androidcoroutines.data.viewmodel

import aaa.android.androidcoroutines.data.DataRepository
import aaa.android.androidcoroutines.data.ResponseUiState
import aaa.android.androidcoroutines.data.model.BookItem
import aaa.android.androidcoroutines.di.modules.ApplicationScope
import androidx.compose.runtime.getValue
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
    private val _bookListLiveData = MutableLiveData<ResponseUiState<List<BookItem>?>>()
    val bookListLiveData: LiveData<ResponseUiState<List<BookItem>?>> = _bookListLiveData


    var searchDisplayValue by mutableStateOf("")


    fun setSearchText(value: String) {
        searchDisplayValue = value
    }


    suspend fun getBookLists(searchText: String) {


        _bookListLiveData.apply {
            postValue(ResponseUiState.Loading())
        }

        val exceptionHandler = CoroutineExceptionHandler { _, exception ->
            _bookListLiveData.apply {
                postValue(
                    exception.message?.let {
                        ResponseUiState.Error(it)
                    }
                )
            }
        }
        try {
            viewModelScope.launch(ioScope.coroutineContext + exceptionHandler) {
                val results = repository.getBookList(searchText)
                _bookListLiveData.apply {
                    postValue(ResponseUiState.Success(results))

                }
            }
        } catch (_: Exception) {


        }
    }

}