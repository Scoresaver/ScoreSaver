package com.example.scoresaver.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MenuViewModel : ViewModel() {

    private val _uiStateButton = MutableStateFlow(false)
    val uiStateButton: StateFlow<Boolean> = _uiStateButton.asStateFlow()

    private val _switchOrderService = MutableStateFlow(false)
    val switchOrderService: StateFlow<Boolean> = _switchOrderService.asStateFlow()

    init {
    }

    fun setSwitchValue(value: Boolean) {
        _switchOrderService.value = value
    }
}