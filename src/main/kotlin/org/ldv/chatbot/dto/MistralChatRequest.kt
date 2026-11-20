package org.ldv.chatbot.dto

data class MistralChatRequest(
    val model: String,
    val messages: List<MistralMessage>
)