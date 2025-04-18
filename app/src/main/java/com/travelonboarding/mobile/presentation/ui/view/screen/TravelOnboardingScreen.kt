/*
 * TravelOnboardingScreen.kt
 * Created by Ulises Gonzalez
 * Copyright (c) 2025. All rights reserved
 */
package com.travelonboarding.mobile.presentation.ui.view.screen

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.travelonboarding.mobile.R
import com.travelonboarding.mobile.domain.model.PageModel
import com.travelonboarding.mobile.presentation.ui.components.PageIndicator
import com.travelonboarding.mobile.util.safeStopRelease
import com.travelonboarding.mobile.util.safeStopReset
import com.travelonboarding.mobile.util.showToast
import com.travelonboarding.mobile.util.togglePlayFromRes

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TravelOnboardingScreen(
    pages: List<PageModel>,
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
) = with(context) {
    val pagerState = rememberPagerState(pageCount = pages.size)
    val mediaPlayer = remember { MediaPlayer() }

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.safeStopRelease(
                onFailure = {
                    showToast(getString(R.string.the_audio_could_not_be_played))
                },
            )
        }
    }

    LaunchedEffect(pagerState.currentPage) {
        mediaPlayer.safeStopReset(
            onFailure = {
                showToast(getString(R.string.the_audio_could_not_be_played))
            },
        )
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.wrapContentSize(),
        ) { currentPage ->
            val currentPageData = pages[currentPage]
            OnboardingPageContent(
                page = currentPageData,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(dimensionResource(R.dimen.padding_big)),
                onPlayAudio = {
                    togglePlayFromRes(
                        mediaPlayer = mediaPlayer,
                        resId = currentPageData.audioResId,
                        onFailure = {
                            showToast(getString(R.string.the_audio_could_not_be_played))
                        },
                    )
                }
            )
        }
        PageIndicator(
            pageCount = pages.size,
            currentPage = pagerState.currentPage,
            modifier = Modifier.padding(2.dp),
        )
    }
}
