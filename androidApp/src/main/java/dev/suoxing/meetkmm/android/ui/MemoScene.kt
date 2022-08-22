package dev.suoxing.meetkmm.android.ui

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import dev.suoxing.meetkmm.UiStatus
import dev.suoxing.meetkmm.model.MemoBook
import dev.suoxing.meetkmm.viewmodel.MemoViewModel

@Composable
fun MemoScene(
    viewModel: MemoViewModel = viewModel()
) {
    LaunchedEffect("") {
        viewModel.start()
    }
    val state = viewModel.uiStateFlow.collectAsState()
    Scaffold {
        if (state.value.status == UiStatus.LOADING) {
            Text(text = "Loading")
        } else {
            MemoBookComponent(
                memoBook = state.value.firstBook,
                onAddMemo = { content, bookName ->
                    viewModel.createMemo(content, bookName)
                },
                onCreateDefaultBook = { viewModel.createMemoBook() }
            )
        }
    }
}

@Composable
fun MemoBookComponent(
    memoBook: MemoBook? = null,
    onAddMemo: (String, String) -> Unit,
    onCreateDefaultBook: () -> Unit
) {
    Column {
        if (memoBook == null) {
            Text(text = "There is no memo books yet.")
            Button(onClick = { onCreateDefaultBook() }) {
                Text(text = "CREATE ONE")
            }
        } else {
            var text by remember {
                mutableStateOf(TextFieldValue())
            }
            Text(text = memoBook.title)
            Text(text = memoBook.memos.joinToString(separator = "\n") {
                it.content
            })
            TextField(value = text, onValueChange = { text = it }, placeholder = {
                Text(text = "add new memo...")
            })
            Button(
                onClick = {
                    onAddMemo(text.text, memoBook.title)
                    text = TextFieldValue()
                }
            ) {
                Text(text = "ADD MEMO")
            }
        }
    }
    
}