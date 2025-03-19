package com.backend.eat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EatApplication

fun main(args: Array<String>) {
	runApplication<EatApplication>(*args)
}
