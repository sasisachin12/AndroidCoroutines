package aaa.android.androidcoroutines

import aaa.android.androidcoroutines.data.model.BookItem
import aaa.android.androidcoroutines.data.viewmodel.BookViewModel
import aaa.android.androidcoroutines.ui.theme.AndroidCoroutinesTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: BookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidCoroutinesTheme {
                GetBookList()
            }
        }
        //getBookLists()

    }


    /*private fun getBookLists() {
        lifecycleScope.launch {
            viewModel.getBookLists("food")
        }
        viewModel.articlesListLiveData.observe(this) {
            when (it) {


                is ResponseData.Error -> {
                    Log.e("getBookLists: ", "" + it.message)
                }

                is ResponseData.Loading -> {
                    Log.e("getBookLists: ", "Result.Loading")
                }

                is ResponseData.Success -> {


                    // Log.e("getBookLists: "," "+it.resultsData?.size )

                    // it.resultsData?.toMutableList()?.let { it1 -> SetBooksAdapter(it1) }
                }
            }
        }
    }*/

    @Composable
    fun GetBookList() {
        val books = viewModel.categoryList

        LaunchedEffect(Unit) {
            viewModel.getBookLists("food")
        }
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
                Text(text = bookItem.volumeInfo?.title.toString(), style = typography.titleLarge)
                Text(text = bookItem.volumeInfo?.subtitle.toString(), style = typography.labelMedium)

            }
        }
    }
}

/*@Composable
private fun PuppyImage(puppy: Item) {
    Image(
        painter = painterResource(id = puppy.volumeInfo.imageLinks.thumbnail),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}*/

