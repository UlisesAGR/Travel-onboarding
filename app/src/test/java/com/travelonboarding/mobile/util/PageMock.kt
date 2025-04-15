/*
 * PageMock.kt - local
 * Created by Ulises Gonzalez on 27/02/25
 * Copyright (c) 2025. All rights reserved
 */
package com.travelonboarding.mobile.util

import com.travelonboarding.mobile.domain.model.PageModel

object PageMock {

    val pages: List<PageModel> =
        listOf(
            PageModel(
                id = 1,
                title = "title",
                description = "description",
                animation = 1,
                audioResId = 1,
            ),
            PageModel(
                id = 2,
                title = "title",
                description = "description",
                animation = 2,
                audioResId = 2,
            )
        )
}
