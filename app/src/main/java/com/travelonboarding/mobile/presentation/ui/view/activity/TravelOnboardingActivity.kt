/*
 * TravelOnboardingActivity.kt
 * Created by Ulises Gonzalez
 * Copyright (c) 2025. All rights reserved
 */
package com.travelonboarding.mobile.presentation.ui.view.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.travelonboarding.mobile.R
import com.travelonboarding.mobile.presentation.ui.components.EmptyState
import com.travelonboarding.mobile.presentation.ui.components.ProgressIndicator
import com.travelonboarding.mobile.presentation.ui.view.screen.TravelOnboardingScreen
import com.travelonboarding.mobile.presentation.viewModel.TravelOnboardingUiState
import com.travelonboarding.mobile.presentation.viewModel.TravelOnboardingViewModel
import com.travelonboarding.mobile.theme.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TravelOnboardingActivity : ComponentActivity() {

    private val viewModel: TravelOnboardingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContainerScreen()
        }
    }

    @Composable
    private fun ContainerScreen() {
        Screen {
            val characterUiEvent = viewModel.travelOnboardingUiState.collectAsState(
                initial = TravelOnboardingUiState.Loading(isLoading = true),
            ).value

            Crossfade(targetState = characterUiEvent) { event ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = dimensionResource(id = R.dimen.padding_small)),
                ) {
                    when (event) {
                        is TravelOnboardingUiState.Loading -> {
                            ProgressIndicator(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(MaterialTheme.colorScheme.background)
                                    .wrapContentSize(Alignment.Center),
                            )
                        }

                        is TravelOnboardingUiState.NoPages -> {
                            EmptyState(
                                title = stringResource(R.string.no_pages),
                                modifier = Modifier.fillMaxSize(),
                            )
                        }

                        is TravelOnboardingUiState.GetPages -> {
                            TravelOnboardingScreen(
                                pages = event.pages,
                                modifier = Modifier.fillMaxSize(),
                            )
                        }
                    }
                }
            }
        }
    }
}
