package dev.suoxing.meetkmm.android

import android.os.Bundle
import dev.suoxing.meetkmm.Greeting
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dev.suoxing.meetkmm.android.ui.MemoScene
import dev.suoxing.meetkmm.viewmodel.HelloViewModel
import dev.suoxing.meetkmm.viewmodel.MemoViewModel
import kotlinx.coroutines.launch

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<HelloViewModel>()
    private val memoViewModel by viewModels<MemoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        memoViewModel.start()
        setContent {
            MaterialTheme {
                MemoScene(memoViewModel)
            }
        }
    }
}
