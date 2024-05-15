package aaa.android.androidcoroutines

import aaa.android.androidcoroutines.data.viewmodel.BookViewModel
import aaa.android.androidcoroutines.ui.theme.AndroidCoroutinesTheme
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: BookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidCoroutinesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        getBookLists()
    }


    private fun getBookLists() {
        lifecycleScope.launch {
            viewModel.getBookLists("food")
        }
        viewModel.articlesListLiveData.observe(this) {
            when (it) {


                is aaa.android.androidcoroutines.data.ResponseData.Error -> {
                    Log.e("getBookLists: ",""+it.message )
                }

                is aaa.android.androidcoroutines.data.ResponseData.Loading -> {
                    Log.e("getBookLists: ","Result.Loading" )
                }

                is aaa.android.androidcoroutines.data.ResponseData.Success -> {
                    Log.e("getBookLists: "," "+it.resultsData?.size )

                }
            }
        }
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidCoroutinesTheme {
        Greeting("Android")
    }
}

