package org.ldv.chatbot.model.entity

import jakarta.persistence.*

@Entity
class ModeleIA(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,

    @Column(nullable = false)
    var nom: String,

    var urlAPI: String ,

    @Column(columnDefinition = "TEXT")
    var description: String? = null,

    @ManyToOne
    @JoinColumn(name = "fournisseur_ia_id")
    var fournisseurIA: FournisseurIA? = null
)