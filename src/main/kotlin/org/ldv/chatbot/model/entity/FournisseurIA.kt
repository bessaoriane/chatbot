package org.ldv.chatbot.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "fournisseur_ia")
data class FournisseurIA(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    var nom: String, // ex: OpenAI, Mistral

    @Column(nullable = false)
    var modele: String, // ex: gpt-4o, mistral-large

    @Column(length = 1000)
    var description: String? = null
)