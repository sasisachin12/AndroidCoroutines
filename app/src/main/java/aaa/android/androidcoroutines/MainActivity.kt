package aaa.android.androidcoroutines

import aaa.android.androidcoroutines.data.ResponseUiState
import aaa.android.androidcoroutines.data.model.BookItem
import aaa.android.androidcoroutines.data.viewmodel.BookViewModel
import aaa.android.androidcoroutines.ui.theme.AndroidCoroutinesTheme
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: BookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidCoroutinesTheme {
                SetHeaderView(viewModel)
            }
        }
    }

}

@Composable
fun SetHeaderView(viewModel: BookViewModel) {
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Type the book name and search the results from google api",
            modifier = Modifier
                .padding(16.dp)
                .padding(16.dp)
                .fillMaxWidth(),
            style = typography.titleLarge
        )
        SearchTextField(viewModel)
        SearchButton(viewModel)
    }

}

@Composable
fun DisplayListView(viewModel: BookViewModel) {

    LaunchedEffect(viewModel.searchDisplayValue) {
        if (viewModel.searchDisplayValue.isNotEmpty()) {
            viewModel.getBookLists(viewModel.searchDisplayValue)
        }
    }
    val items by viewModel.bookListLiveData.observeAsState()
    when (items) {
        is ResponseUiState.Success<*> -> {
            val books = items?.data as List<BookItem>
            if (books.isNotEmpty()) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items(
                        items = books,
                        itemContent = {
                            BookListItem(bookItem = it)
                        })
                }


            }
        }

        is ResponseUiState.Error -> {
            val error = items?.message
            Text(text =error.toString(), style = typography.titleLarge)
            Log.e("ResponseUiState.Error", "DisplayListView: $error")
        }

        is ResponseUiState.Loading -> {
            IndeterminateCircularIndicator()
        }

        null -> {

        }

        else -> {

        }
    }

}

@Composable
fun BookListItem(bookItem: BookItem) {


    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        //elevation = CardElevation(2.dp,2.dp,2.dp,2.dp,2.dp,2.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))

    ) {
        Row {
            // PuppyImage(puppy)
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                val imageUrl = bookItem.volumeInfo?.imageLinks?.thumbnail.toString()
                val subTitle = bookItem.volumeInfo?.subtitle.toString()
                if (imageUrl.isNotEmpty()) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(imageUrl)
                            .build(),
                        contentDescription = "image",
                        modifier = Modifier
                            .size(120.dp)
                    )

                }
                Text(text = bookItem.volumeInfo?.title.toString(), style = typography.titleLarge)
                if (subTitle.isNotEmpty()) {
                    Text(
                        text = subTitle,
                        style = typography.labelMedium
                    )
                }

            }
        }
    }
}

@Composable
fun SearchTextField(viewModel: BookViewModel) {
    OutlinedTextField(
        value = viewModel.searchDisplayValue,
        onValueChange = { newText ->
            viewModel.setSearchText(newText)
        },
        singleLine = true,
        textStyle = typography.bodySmall,
        modifier = Modifier
            .padding(16.dp)
            .padding(8.dp)
            .fillMaxWidth()
    )
}

@Composable
fun SearchButton(viewModel: BookViewModel) {
    val searchValue = remember { mutableStateOf(false) }
    ElevatedButton(
        onClick = {
            searchValue.value = !searchValue.value
        },
        content = { Text("Search") },
        colors = ButtonDefaults.elevatedButtonColors(),
        modifier = Modifier.padding(4.dp),
    )
    if (searchValue.value) {
        DisplayListView(viewModel)
    }
}

@Composable
fun IndeterminateCircularIndicator() {
    CircularProgressIndicator(
        modifier = Modifier.width(64.dp),
        color = MaterialTheme.colorScheme.secondary,
        trackColor = MaterialTheme.colorScheme.surfaceVariant,
    )
}



