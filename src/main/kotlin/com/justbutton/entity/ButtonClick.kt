package com.justbutton.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class ButtonClick(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val clickedAt: LocalDateTime = LocalDateTime.now()
)
