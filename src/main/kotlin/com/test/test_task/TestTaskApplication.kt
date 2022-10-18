package com.test.test_task

import com.test.test_task.bot.configuration.ApplicationConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.AnnotationConfigApplicationContext

@SpringBootApplication
class TestTaskApplication

fun main(args: Array<String>) {
	runApplication<TestTaskApplication>(*args)
	AnnotationConfigApplicationContext(ApplicationConfiguration::class.java)
}
