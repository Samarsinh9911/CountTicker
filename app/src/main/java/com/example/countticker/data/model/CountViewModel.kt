package com.example.myapplication.data.model
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

 class CountViewModel {


   class CountViewModel : ViewModel() {

        private val _countState = MutableStateFlow(CountState())
        val countState: StateFlow<CountState> = _countState

        fun incrementCount() {
            viewModelScope.launch {
                val currentCount = _countState.value.count
                _countState.value = CountState(currentCount + 1)
            }
        }

        fun decrementCount() {
            viewModelScope.launch {
                val currentCount = _countState.value.count
                _countState.value = CountState(currentCount - 1)
            }
        }

        fun resetCount() {
            viewModelScope.launch {
                _countState.value = CountState()
            }
        }
       fun printText(){
           viewModelScope.launch {
               _countState.value = CountState()
           }
       }
    }

}