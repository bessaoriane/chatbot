package org.ldv.chatbot.model.entity

import jakarta.persistence.*

@Entity
class FournisseurIA(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var nom: String,

    @Column(nullable = false)
    var siteWeb: String? = null,

    @OneToMany(mappedBy = "fournisseurIA", cascade = [CascadeType.ALL], orphanRemoval = true)
    var modeles: MutableList<ModeleIA> = mutableListOf()
)