//
//  ViewModelObservable.swift
//  iosApp
//
//  Created by 王轶凡 on 2022/8/17.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI

///
/// Wrap KMM ViewModel to `ObservableObject` with a published `uiState`.
///
@MainActor
class ObservableViewModel<UiState: AnyObject, VM: Kmm_archViewModel<UiState>> : ObservableObject{
    
    ///
    /// `UiState` type can be inferred from `vm` instance passed to wrapper.
    ///
    @Published var uiState: UiState
    
    
    ///
    /// Real KMM ViewModel reference.
    ///
    /// Named as `actor` in order to inform developer to invoke this only for handling user actions.
    ///
    /// Little bit ugly, but I think it's okay. 😅
    ///
    let actor: VM
    
    init (_ vm: VM) {
        // peek latest value to guarantee that `uiState` is always non-null.
        self.uiState = vm.peek()
        self.actor = vm
        vm.collect { value in
            // update `uiState` everytime `uiStateFlow` emits new value.
            self.uiState = value
        }
    }
    
    deinit {
        // cancel coroutine scope
        self.actor.onCleared()
    }
}
