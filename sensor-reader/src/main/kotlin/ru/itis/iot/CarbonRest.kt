package ru.itis.iot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class CarbonRest(
    private val cache: Deque<String>
) {

    @GetMapping("/carbon-dioxide")
    fun getData(): String = cache.last
}