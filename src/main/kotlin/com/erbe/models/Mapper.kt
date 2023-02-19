package com.erbe.models

fun Content.asContentTopic(topic: Topic?) = ContentTopic(
    id = id,
    title = title,
    tag = tag,
    subtitle = subtitle,
    content = content,
    image = image,
    date = date,
    time = time,
    topic = topic,
    url = url
)

fun Topic.asTopicContent(listContent: List<Content>) = TopicContent(
    id = id,
    name = name,
    tag = tag,
    description = description,
    image = image,
    total = total,
    itemContent = listContent,
    url = url
)