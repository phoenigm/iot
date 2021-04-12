package ru.itis.iot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class CarboRest(
    private val cache: Deque<String>
) {

    @GetMapping
    fun getData(): String = cache.last
}