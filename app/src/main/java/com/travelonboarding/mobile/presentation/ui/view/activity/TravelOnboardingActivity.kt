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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.travelonboarding.mobile.R
import com.travelonboarding.mobile.presentation.ui.view.screen.TravelOnboardingScreen
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
            Container(viewModel)
        }
    }

    @Composable
    private fun Container(viewModel: TravelOnboardingViewModel) {
        Screen {
            val characterUiEvent = viewModel.travelOnboardingUiState.collectAsState().value

            Crossfade(targetState = characterUiEvent) { event ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = dimensionResource(id = R.dimen.padding_small)),
                ) {
                    TravelOnboardingScreen(
                        pages = event.pages,
                        modifier = Modifier.fillMaxSize(),
                    )
                }
            }
        }
    }
}
