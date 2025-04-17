/*
 * TravelOnboardingViewModel.kt
 * Created by Ulises Gonzalez
 * Copyright (c) 2025. All rights reserved
 */
package com.travelonboarding.mobile.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.common.util.VisibleForTesting
import com.travelonboarding.mobile.presentation.ui.provider.PagesProviderImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TravelOnboardingViewModel @Inject constructor(
    private val pagesProviderImpl: PagesProviderImpl,
) : ViewModel() {

    private var _travelOnboardingUiState = MutableStateFlow(TravelOnboardingUiState())
    val travelOnboardingUiState: StateFlow<TravelOnboardingUiState> = _travelOnboardingUiState

    init {
        getPages()
    }

    @VisibleForTesting
    fun getPages() = viewModelScope.launch {
        _travelOnboardingUiState.value = _travelOnboardingUiState.value.copy(
            pages = pagesProviderImpl.getPages(),
        )
    }
}
