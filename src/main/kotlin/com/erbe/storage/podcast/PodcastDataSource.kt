package com.erbe.storage.podcast

import com.erbe.models.asContentTopic
import com.erbe.models.asTopicContent

// list podcast
fun podcastContentTopicStorage() =
    podcastContentStorage.map { content ->
        content.asContentTopic(podcastTopicStorage.find { topic -> topic.tag == content.tag })
    }

// latest podcast
fun podcastContentTopicLatest() = podcastContentTopicStorage().take(5)

// list category podcast
fun podcastTopicContentStorage(tag: String) =
    podcastTopicStorage.find { topic -> topic.tag == tag }
        ?.asTopicContent(podcastContentStorage.filter { content -> content.tag == tag })

// latest category podcast
fun podcastTopicContentLatest() =
    podcastTopicStorage.map { topic ->
        topic.asTopicContent(podcastContentStorage.filter { content -> content.tag == topic.tag })
    }

// detail podcast
fun podcastDetail(id: String) =
    podcastContentTopicStorage().find { content -> content.id == id }