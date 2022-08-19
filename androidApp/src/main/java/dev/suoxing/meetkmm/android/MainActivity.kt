package dev.suoxing.meetkmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.suoxing.meetkmm.Greeting
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dev.suoxing.meetkmm.viewmodel.HelloViewModel
import kotlinx.coroutines.launch

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<HelloViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.uiStateFlow.collect {
                    tv.text = it
                }
            }
        }
    }
}
