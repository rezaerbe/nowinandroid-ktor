package com.erbe.storage.video

import com.erbe.models.Content
import com.erbe.utils.contentVideo
import com.erbe.utils.date

val videoStorage = mutableListOf(
    Content(
        title = "Now in Android: 75 - Android Studio Electric Eel, Architecture, Kotlin Multiplatform, and more!",
        subtitle = "Welcome to Now in Android, your ongoing guide to what’s new and notable in the world of Android development. Today, we’re covering updates on the release of Android Studio Electric Eel, AndroidX releases, articles, videos, podcast, and more!",
        content = contentVideo("index.html"),
        image = "https://i3.ytimg.com/vi/o6OQh1_PFsw/maxresdefault.jpg",
        date = date(2023, 1, 19),
        time = "5",
        topic = videoTopicStorage[0],
        url = "https://youtu.be/o6OQh1_PFsw"
    ),
    Content(
        title = "Now in Android: 74 - Android 13 for TV, Compose for Wear OS 1.1, Privacy Sandbox Beta, and more!",
        subtitle = "Welcome to Now in Android, your ongoing guide to what’s new and notable in the world of Android development. Today, we’re covering updates on Android 13 for TV + the TV archivable Android app bundle requirement, Compose for Wear OS 1.1, Android Architecture Starter Templates, preparing for the Android Privacy Sandbox Beta, and much more!",
        content = contentVideo("index.html"),
        image = "https://i3.ytimg.com/vi/o3UAj4qaoCY/maxresdefault.jpg",
        date = date(2022, 12, 23),
        time = "6",
        topic = videoTopicStorage[0],
        url = "https://youtu.be/o3UAj4qaoCY"
    ),
    Content(
        title = "Now in Android: 73 - Android Dev Summit: Platform, Now in Android on Google Play, and more!",
        subtitle = "Welcome to Now in Android, your ongoing guide to what’s new and notable in the world of Android development. Today, we’re covering updates on the Platform track at #AndroidDevSummit ‘22, Health Connect, Now in Android on Google Play, user choice billing, and more!",
        content = contentVideo("index.html"),
        image = "https://i3.ytimg.com/vi/kMmkG5MUREY/maxresdefault.jpg",
        date = date(2022, 11, 17),
        time = "5",
        topic = videoTopicStorage[0],
        url = "https://youtu.be/kMmkG5MUREY"
    ),
    Content(
        title = "Now in Android: 72 - Android Dev Summit: Form Factors, Health Services, Google Play, and more!",
        subtitle = "Welcome to Now in Android, your ongoing guide to what’s new and notable in the world of Android development. Today, we’re covering updates on the Form Factors track at #AndroidDevSummit '22,  Health Services API, Google Play, Android performance, and more!",
        content = contentVideo("index.html"),
        image = "https://i3.ytimg.com/vi/3IHKeMdmDOI/maxresdefault.jpg",
        date = date(2022, 11, 12),
        time = "4",
        topic = videoTopicStorage[0],
        url = "https://youtu.be/3IHKeMdmDOI"
    ),
    Content(
        title = "Now in Android: 71 - #AndroidDevSummit, Modern Android Development, Now in Android app, and more!",
        subtitle = "Welcome to Now in Android, your ongoing guide to what’s new and notable in the world of Android development. Today, @manuelvicnt covers updates on what’s new from Android at Android Developer Summit 2022, Modern Android Development track at ADS, @materialdesign releases, articles, videos, and more!",
        content = contentVideo("index.html"),
        image = "https://i3.ytimg.com/vi/WgxwzyMuKkQ/maxresdefault.jpg",
        date = date(2022, 11, 5),
        time = "8",
        topic = videoTopicStorage[0],
        url = "https://youtu.be/WgxwzyMuKkQ"
    )
).sortedByDescending { it.date }