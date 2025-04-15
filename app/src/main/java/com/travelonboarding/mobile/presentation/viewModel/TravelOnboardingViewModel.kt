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
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TravelOnboardingViewModel @Inject constructor(
    private val pagesProviderImpl: PagesProviderImpl,
) : ViewModel() {

    private var _travelOnboardingUiState = MutableSharedFlow<TravelOnboardingUiState>(replay = 1)
    val travelOnboardingUiState: SharedFlow<TravelOnboardingUiState> = _travelOnboardingUiState

    init {
        getPages()
    }

    @VisibleForTesting
    fun getPages() = viewModelScope.launch {
        _travelOnboardingUiState.emit(TravelOnboardingUiState.Loading(isLoading = true))
        val pages = pagesProviderImpl.getPages()
        if (pages.isNotEmpty()) {
            _travelOnboardingUiState.apply {
                emit(TravelOnboardingUiState.Loading(isLoading = false))
                emit(TravelOnboardingUiState.GetPages(pages))
            }
        } else {
            _travelOnboardingUiState.apply {
                emit(TravelOnboardingUiState.Loading(isLoading = false))
                emit(TravelOnboardingUiState.NoPages)
            }
        }
    }
}
