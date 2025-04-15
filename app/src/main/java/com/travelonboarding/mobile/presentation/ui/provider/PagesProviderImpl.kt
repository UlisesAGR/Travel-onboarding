/*
 * PagesProviderImpl.kt
 * Created by Ulises Gonzalez
 * Copyright (c) 2025. All rights reserved
 */
package com.travelonboarding.mobile.presentation.ui.provider

import android.content.Context
import com.travelonboarding.mobile.R
import com.travelonboarding.mobile.domain.model.PageModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PagesProviderImpl @Inject constructor(
    @ApplicationContext val context: Context,
) : PagesProvider {

    private val resource = context.applicationContext.resources

    override fun getPages(): List<PageModel> =
        listOf(
            PageModel(
                animation = R.raw.suitcases,
                title = resource.getString(R.string.prepare_your_bags),
                description = resource.getString(R.string.bring_everything_you_need_to_enjoy_your_trip),
                audioResId = R.raw.inside_airport,
            ),
            PageModel(
                animation = R.raw.plane,
                title = resource.getString(R.string.time_to_travel),
                description = resource.getString(R.string.enjoy_the_flight_we_are_about_to_reach_our_destination),
                audioResId = R.raw.inside_plane,
            ),
            PageModel(
                animation = R.raw.beach,
                title = resource.getString(R.string.beach_sun_sand),
                description = resource.getString(R.string.enjoy_your_vacation_to_the_fullest_you_deserve_it),
                audioResId = R.raw.inside_beach,
            ),
            PageModel(
                animation = R.raw.park,
                title = resource.getString(R.string.enjoy_the_parks),
                description = resource.getString(R.string.live_with_family_and_live_life),
                audioResId = R.raw.inside_park,
            ),
            PageModel(
                animation = R.raw.suitcases,
                title = resource.getString(R.string.back_home),
                description = resource.getString(R.string.it_s_time_to_go_home_it_was_a_good_trip),
                audioResId = R.raw.inside_airport,
            ),
        )
}
