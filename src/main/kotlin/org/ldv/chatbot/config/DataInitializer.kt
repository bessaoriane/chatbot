package org.ldv.chatbot.config

import org.ldv.chatbot.model.dao.FournisseurIARepository
import org.ldv.chatbot.model.dao.ModeleIARepository
import org.ldv.chatbot.model.entity.FournisseurIA
import org.ldv.chatbot.model.entity.ModeleIA
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataInitializer(
    private val fournisseurIARepository: FournisseurIARepository,
    private val modeleIARepository: ModeleIARepository
) {

    @Bean
    fun initData() = CommandLineRunner {

        val mistral = fournisseurIARepository.findAll()
            .firstOrNull { it.nom == "Mistral" }
            ?: fournisseurIARepository.save(
                FournisseurIA(
                    nom = "Mistral",
                    siteWeb = "https://mistral.ai"
                )
            )

        val gemini = fournisseurIARepository.findAll()
            .firstOrNull { it.nom == "Gemini" }
            ?: fournisseurIARepository.save(
                FournisseurIA(
                    nom = "Gemini",
                    siteWeb = "https://ai.google.dev"
                )
            )

        val modeles = listOf(
            ModeleIA(
                nom = "gemini-3.8-flash",
                urlAPI = "https://generativelanguage.googleapis.com/v1beta/models/gemini-3.8-flash:generateContent",
                description = "Modèle rapide et polyvalent.",
                fournisseurIA = gemini
            ),
            ModeleIA(
                nom = "gemini-3.5-flash-lite",
                urlAPI = "https://generativelanguage.googleapis.com/v1beta/models/gemini-3.5-flash-lite:generateContent",
                description = "Modèle rapide pour les tâches simples.",
                fournisseurIA = gemini
            ),
            ModeleIA(
                nom = "mistral-small-latest",
                urlAPI = "https://api.mistral.ai/v1/chat/completions",
                description = "Modèle léger pour les conversations et les tâches courantes.",
                fournisseurIA = mistral
            ),
            ModeleIA(
                nom = "mistral-medium-latest",
                urlAPI = "https://api.mistral.ai/v1/chat/completions",
                description = "Modèle plus avancé pour les tâches complexes.",
                fournisseurIA = mistral
            )
        )

        for (modele in modeles) {
            val existe = modeleIARepository.findAll().any { it.nom == modele.nom }
            if (!existe) {
                modeleIARepository.save(modele)
            }
        }
    }
}