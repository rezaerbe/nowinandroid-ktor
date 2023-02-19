package com.erbe.storage.article

import com.erbe.models.Content
import com.erbe.utils.contentArticle
import com.erbe.utils.date

val articleContentStorage = mutableListOf(
    Content(
        id = "1",
        title = "Now in Android #75",
        tag = "now-in-android",
        subtitle = "Android Studio Electric Eel, Architecture, Kotlin Multiplatform, WearOS, CameraX, Stylus, and more.",
        content = contentArticle("index.html"),
        image = "https://miro.medium.com/0*IdylXqMS2sF3Nh30",
        date = date(2023, 1, 19),
        time = "4",
        url = "https://medium.com/androiddevelopers/now-in-android-75-e4bbe977d33f"
    ),
    Content(
        id = "2",
        title = "Now in Android #74",
        tag = "now-in-android",
        subtitle = "Android 13 for TV, Compose for Wear OS 1.1, Android Privacy Sandbox Beta, Camera Viewfinder, Architecture Templates, Shaders and Graphics, Google Play, Jetpack Compose, and more.",
        content = contentArticle("index.html"),
        image = "https://miro.medium.com/0*EUh5iWsPNCiAJm93",
        date = date(2022, 12, 22),
        time = "8",
        url = "https://medium.com/androiddevelopers/now-in-android-74-886a95404e8b"
    ),
    Content(
        id = "3",
        title = "Now in Android #73",
        tag = "now-in-android",
        subtitle = "Android Dev Summit: Platform track, Health Connect, Now in Android on Google Play, user choice billing, lazy layouts",
        content = contentArticle("index.html"),
        image = "https://miro.medium.com/0*xEuK15gUA0YXznsR",
        date = date(2022, 11, 17),
        time = "5",
        url = "https://medium.com/androiddevelopers/now-in-android-73-f0effa197dfb"
    ),
    Content(
        id = "4",
        title = "Now in Android #72",
        tag = "now-in-android",
        subtitle = "Android Dev Summit: Form Factors, Health Services, Google Play updates, Performance, and more!",
        content = contentArticle("index.html"),
        image = "https://miro.medium.com/0*owVH_IF5OJcUVv0R",
        date = date(2022, 11, 12),
        time = "6",
        url = "https://medium.com/androiddevelopers/now-in-android-72-1dba1cd404a"
    ),
    Content(
        id = "5",
        title = "Now in Android #71",
        tag = "now-in-android",
        subtitle = "Android Dev Summit, Modern Android development, Kotlin Multiplatform, Material Design, Now in Android app, and more!",
        content = contentArticle("index.html"),
        image = "https://miro.medium.com/0*99F5VQ7eRCJivVpF",
        date = date(2022, 11, 5),
        time = "7",
        url = "https://medium.com/androiddevelopers/now-in-android-71-248cd926bf7c"
    )
).sortedByDescending { content -> content.date }