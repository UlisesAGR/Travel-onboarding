/*
 * TravelOnboardingUiState.kt
 * Created by Ulises Gonzalez
 * Copyright (c) 2025. All rights reserved
 */
package com.travelonboarding.mobile.presentation.viewModel

import com.travelonboarding.mobile.domain.model.PageModel

data class TravelOnboardingUiState(
    val pages: List<PageModel> = emptyList(),
)
