package org.ldv.chatbot.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ChatBotController {

    // Redirige la racine "/" vers index.html
    /*@GetMapping("/")
    fun home(): String {
        return "utilisateur/index"
    }*/


    // Gère à la fois /login ET /auth/login pour éviter l'erreur
    @GetMapping("/login")
    fun login(): String {
        return "login"
    }
}