package com.erbe.storage

import com.erbe.models.Content
import com.erbe.utils.contentArticle
import com.erbe.utils.date
import com.erbe.utils.image

val articleStorage = mutableListOf(
    Content(
        "1",
        "Now in Android #75",
        "Android Studio Electric Eel, Architecture, Kotlin Multiplatform, WearOS, CameraX, Stylus, and more.",
        contentArticle("index.html"),
        image("0*IdylXqMS2sF3Nh30"),
        date(2022, 1, 19),
        "4 min",
        articleTopicStorage[0],
        "https://medium.com/androiddevelopers/now-in-android-75-e4bbe977d33f"
    )
)