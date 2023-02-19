package com.erbe.storage.video

import com.erbe.models.asContentTopic
import com.erbe.models.asTopicContent

// list video
fun videoContentTopicStorage() =
    videoContentStorage.map { content ->
        content.asContentTopic(videoTopicStorage.find { topic -> topic.tag == content.tag })
    }

// latest video
fun videoContentTopicLatest() = videoContentTopicStorage().take(5)

// list category video
fun videoTopicContentStorage(tag: String) =
    videoTopicStorage.find { topic -> topic.tag == tag }
        ?.asTopicContent(videoContentStorage.filter { content -> content.tag == tag })

// latest category video
fun videoTopicContentLatest() =
    videoTopicStorage.map { topic ->
        topic.asTopicContent(videoContentStorage.filter { content -> content.tag == topic.tag })
    }

// detail video
fun videoDetail(id: String) =
    videoContentTopicStorage().find { content -> content.id == id }