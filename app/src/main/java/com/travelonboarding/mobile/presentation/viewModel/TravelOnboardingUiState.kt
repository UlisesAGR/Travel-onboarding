/*
 * TravelOnboardingUiState.kt
 * Created by Ulises Gonzalez
 * Copyright (c) 2025. All rights reserved
 */
package com.travelonboarding.mobile.presentation.viewModel

import com.travelonboarding.mobile.domain.model.PageModel

sealed class TravelOnboardingUiState {
    internal data class Loading(val isLoading: Boolean) : TravelOnboardingUiState()
    internal data object NoPages : TravelOnboardingUiState()
    internal data class GetPages(val pages: List<PageModel>) : TravelOnboardingUiState()
}
