package org.ldv.chatbot.model.dao

import org.ldv.chatbot.model.entity.Conversation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.time.LocalDateTime

interface ConversationRepository : JpaRepository<Conversation, Long> {
    fun findAllByOrderByDateCreationDesc(): List<Conversation>




}