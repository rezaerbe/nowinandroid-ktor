package com.erbe.storage.article

import com.erbe.models.asContentTopic
import com.erbe.models.asTopicContent

// list article
fun articleContentTopicStorage() =
    articleContentStorage.map { content ->
        content.asContentTopic(articleTopicStorage.find { topic -> topic.tag == content.tag })
    }

// latest article
fun articleContentTopicLatest() = articleContentTopicStorage().take(5)

// list category article
fun articleTopicContentStorage(tag: String) =
    articleTopicStorage.find { topic -> topic.tag == tag }
        ?.asTopicContent(articleContentStorage.filter { content -> content.tag == tag })

// latest category article
fun articleTopicContentLatest() =
    articleTopicStorage.map { topic ->
        topic.asTopicContent(articleContentStorage.filter { content -> content.tag == topic.tag })
    }

// detail article
fun articleDetail(id: String) =
    articleContentTopicStorage().find { content -> content.id == id }