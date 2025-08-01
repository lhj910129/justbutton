package com.justbutton.controller

import com.justbutton.entity.ButtonClick
import com.justbutton.repository.ButtonClickRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PingController(
    private val buttonClickRepository: ButtonClickRepository
) {
    @GetMapping("/ping")
    fun ping(): String {
        buttonClickRepository.save(ButtonClick()) // 클릭 기록 저장
        return "참 잘했어요"
    }
}
