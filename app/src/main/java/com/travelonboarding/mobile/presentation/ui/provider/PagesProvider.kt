/*
 * PagesProvider.kt
 * Created by Ulises Gonzalez
 * Copyright (c) 2025. All rights reserved
 */
package com.travelonboarding.mobile.presentation.ui.provider

import com.travelonboarding.mobile.domain.model.PageModel

interface PagesProvider {
    fun getPages(): List<PageModel>
}
