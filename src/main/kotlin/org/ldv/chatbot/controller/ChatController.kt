package org.ldv.chatbot.controller

import org.ldv.chatbot.model.dao.MessageRepository
import org.ldv.chatbot.model.dao.ModeleIARepository
import org.ldv.chatbot.service.IAServiceFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ChatController(
    private val iaServiceFactory: IAServiceFactory,
    private val conversationDAO: ConversationDAO,
    private val messageDAO: MessageRepository,
    private val modeleIADAO: ModeleIARepository
) {

}

@GetMapping("/")
fun accueil(model: ModeleIARepository): String {

    // Retire la conversation courante
    model.addAttribute("conversation", null)

    model.addAttribute("modeles", modeleIADAO.findAll())
    model.addAttribute("messages", emptyList<Message>())
    model.addAttribute(
        "conversations",
        conversationDAO.findAllByOrderByDateDerniereModificationDesc()
    )

    return "utilisateur/chat"
}