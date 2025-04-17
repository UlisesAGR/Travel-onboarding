/*
 * TravelOnboardingViewModelTest.kt
 * Created by Ulises Gonzalez
 * Copyright (c) 2025. All rights reserved
 */
package com.travelonboarding.mobile.presenter

import com.travelonboarding.mobile.domain.model.PageModel
import com.travelonboarding.mobile.presentation.ui.provider.PagesProviderImpl
import com.travelonboarding.mobile.presentation.viewModel.TravelOnboardingViewModel
import com.travelonboarding.mobile.util.DispatcherRule
import com.travelonboarding.mobile.util.PageMock.pages
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@HiltAndroidTest
class TravelOnboardingViewModelTest {

    @Mock
    lateinit var pagesProviderImpl: PagesProviderImpl

    private lateinit var travelOnboardingViewModel: TravelOnboardingViewModel

    @get:Rule
    val dispatcherRule = DispatcherRule()

    @Before
    fun setUp() {
        travelOnboardingViewModel = TravelOnboardingViewModel(pagesProviderImpl)
    }

    @Test
    fun `Get Pages with info - Test`(): Unit = runTest {
        // Given
        val expected: List<PageModel> = pages
        `when`(pagesProviderImpl.getPages()).thenReturn(pages)
        // When
        travelOnboardingViewModel.getPages()
        // Then
        val state = travelOnboardingViewModel.travelOnboardingUiState.first()
        assertEquals(expected, state.pages)
    }

    @Test
    fun `Get Pages without info - Test`(): Unit = runTest {
        // Given
        val expected: List<PageModel> = emptyList()
        `when`(pagesProviderImpl.getPages()).thenReturn(emptyList())
        // When
        travelOnboardingViewModel.getPages()
        // Then
        val state = travelOnboardingViewModel.travelOnboardingUiState.first()
        assertEquals(expected, state.pages)
    }
}
