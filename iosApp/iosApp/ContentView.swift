import SwiftUI
import Combine
import shared

struct ContentView: View {
    @ObservedObject var viewModel = ObservableViewModel(HelloViewModel())

	var body: some View {
        Text(viewModel.uiState as String)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView()
	}
}
