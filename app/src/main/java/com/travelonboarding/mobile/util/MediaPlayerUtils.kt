/*
 * MediaPlayerUtils.kt
 * Created by Ulises Gonzalez
 * Copyright (c) 2025. All rights reserved
 */
package com.travelonboarding.mobile.util

import android.content.Context
import android.media.MediaPlayer

fun MediaPlayer.safeStopRelease(onFailure: () -> Unit) {
    runCatching {
        if (isPlaying) {
            stop()
        }
        release()
    }.onFailure {
        log(it.message.toString())
        onFailure()
    }
}

fun MediaPlayer.safeStopReset(onFailure: () -> Unit) {
    runCatching {
        if (isPlaying) {
            stop()
        }
        reset()
    }.onFailure {
        log(it.message.toString())
        onFailure()
    }
}

fun Context.togglePlayFromRes(
    mediaPlayer: MediaPlayer,
    resId: Int,
    onFailure: () -> Unit,
) {
    runCatching {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
            mediaPlayer.reset()
        } else {
            val assetFileDescriptor = this.resources.openRawResourceFd(resId)
            mediaPlayer.setDataSource(
                assetFileDescriptor.fileDescriptor,
                assetFileDescriptor.startOffset,
                assetFileDescriptor.length,
            )
            assetFileDescriptor.close()
            mediaPlayer.prepare()
            mediaPlayer.start()
        }
    }.onFailure {
        log(it.message.toString())
        onFailure()
    }
}
