package com.erbe.storage.podcast

import com.erbe.models.Content
import com.erbe.utils.contentPodcast
import com.erbe.utils.date

val podcastStorage = mutableListOf(
    Content(
        title = "75 - Android Studio Electric Eel, Architecture, Kotlin Multiplatform, and more!",
        subtitle = "Welcome to Now in Android, your ongoing guide to what’s new and notable in the world of Android development. Today, we’re covering updates on the release of Android Studio Electric Eel, AndroidX releases, articles, videos, podcast, and more!",
        content = contentPodcast("index.html"),
        image = "https://ssl-static.libsyn.com/p/assets/9/c/c/c/9ccc56e0148bdb91d959afa2a1bf1c87/NIA075_Podcast_Thumb.jpg",
        date = date(2023, 1, 18),
        time = "5",
        topic = podcastTopicStorage[0],
        url = "https://open.spotify.com/episode/3EMbwWJrqG4o8XAnDqdnxZ"
    ),
    Content(
        title = "74 - Android 13 for TV, Compose for Wear OS 1.1, Privacy Sandbox Beta, and more!",
        subtitle = "Welcome to Now in Android, your ongoing guide to what’s new and notable in the world of Android development. Today, we’re covering updates on Android 13 for TV, archivable Android app bundle requirement, Compose for Wear OS 1.1, preparing for the Android Privacy Sandbox Beta, and much more!",
        content = contentPodcast("index.html"),
        image = "https://ssl-static.libsyn.com/p/assets/7/d/2/a/7d2a9aea304107d116c3140a3186d450/NIA074_Podcast_Thumb.jpg",
        date = date(2022, 12, 22),
        time = "6",
        topic = podcastTopicStorage[0],
        url = "https://open.spotify.com/episode/18aeVfXJMCmQWXb1yWLqht"
    ),
    Content(
        title = "73 - Android Dev Summit: Platform, Now in Android on Google Play, and more!",
        subtitle = "Welcome to Now in Android, your ongoing guide to what’s new and notable in the world of Android development. Today, we’re covering updates on the Platform track at #AndroidDevSummit ‘22, Health Connect, Now in Android on Google Play, user choice billing, and more!",
        content = contentPodcast("index.html"),
        image = "https://ssl-static.libsyn.com/p/assets/6/6/1/5/66152421c85ec579bafc7308ab683e82/NIA073_Podcast_Thumb.jpg",
        date = date(2022, 11, 16),
        time = "5",
        topic = podcastTopicStorage[0],
        url = "https://open.spotify.com/episode/6iICrMTz2cs49NsripSU5o"
    ),
    Content(
        title = "72 - Android Dev Summit: Form Factors, Health Services, Google Play, and more!",
        subtitle = "Welcome to Now in Android, your ongoing guide to what’s new and notable in the world of Android development. Today, we’re covering updates on the Form Factors track at #AndroidDevSummit 2022, Health Services API, Google Play, Android performance, and more!",
        content = contentPodcast("index.html"),
        image = "https://ssl-static.libsyn.com/p/assets/0/2/5/3/0253f934ffeb600b27a2322813b393ee/NIA072_Podcast_Thumb.jpg",
        date = date(2022, 11, 11),
        time = "4",
        topic = podcastTopicStorage[0],
        url = "https://open.spotify.com/episode/6bnUJ0qV8BatNS9Uq8NVkd"
    ),
    Content(
        title = "71 - #AndroidDevSummit, Modern Android Development, Now in Android app, and more!",
        subtitle = "Welcome to Now in Android, your ongoing guide to what’s new and notable in the world of Android development. Today, Manuel covers updates on what’s new from Android at Android Developer Summit 2022, Modern Android Development track at ADS, Material Design releases, articles, videos, and more!",
        content = contentPodcast("index.html"),
        image = "https://ssl-static.libsyn.com/p/assets/e/d/b/5/edb5a35d5d0b9de8a04421dee9605cbd/NIA071_Podcast_Thumb.jpg",
        date = date(2022, 11, 4),
        time = "8",
        topic = podcastTopicStorage[0],
        url = "https://open.spotify.com/episode/1ORsxljfZJXPEV84gFPRva"
    )
)