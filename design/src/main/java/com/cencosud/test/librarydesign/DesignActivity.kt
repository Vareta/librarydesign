package com.cencosud.test.librarydesign

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cencosud.test.core.TestButton
import com.cencosud.test.librarydesign.ui.theme.LibrarydesignTheme

class DesignActivity : ComponentActivity() {
    private var activityStrings: String = "Texto propio de design activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(intent) {
            getStringExtra(STRINGS)?.let { activityStrings = it }
        }
        setContent {
            LibrarydesignTheme {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    TestButton(modifier = Modifier.padding(32.dp))
                    Text(modifier = Modifier.padding(32.dp), text = getString(R.string.text_1))
                    Text(modifier = Modifier.padding(32.dp), text = getString(R.string.text_2))
                    Text(modifier = Modifier.padding(32.dp), text = getString(R.string.text_3))
                }
            }
        }
    }


    companion object {
        private const val STRINGS = "strings"
        fun createIntent(
            context: Context,
            texts: String? = null
        ): Intent {
            return Intent(context, DesignActivity::class.java).apply {
                putExtra(STRINGS, texts)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        color = Color.Blue,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LibrarydesignTheme {
        Greeting("Android")
    }
}

