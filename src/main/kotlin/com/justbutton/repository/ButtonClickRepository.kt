package com.justbutton.repository

import com.justbutton.entity.ButtonClick
import org.springframework.data.jpa.repository.JpaRepository

interface ButtonClickRepository : JpaRepository<ButtonClick, Long>
