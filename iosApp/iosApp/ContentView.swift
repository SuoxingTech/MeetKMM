import SwiftUI
import Combine
import shared

struct ContentView: View {
    @ObservedObject var viewModel = ObservableViewModel(MemoViewModel())
    @State var input: String = ""
    
    init() {
        viewModel.actor.start()
    }

	var body: some View {
        if viewModel.uiState.firstBook != nil {
            Text(viewModel.uiState.firstBook?.title ?? "No Title")
            Text((viewModel.uiState.firstBook?.memos
                .map { m in
                    (m as! Memo).content
                }
                .joined(separator: "\n")) ?? "no memos")
            TextField("input memo", text: $input)
            Button("ADD MEMO", action: {
                viewModel.actor.createMemo(content: input, bookName: viewModel.uiState.firstBook?.title ?? "")
                input = ""
            })
        } else {
            Text("There is no memo books yet.")
            Button("CREATE ONE", action: {
                viewModel.actor.createMemoBook()
            })
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView()
	}
}
