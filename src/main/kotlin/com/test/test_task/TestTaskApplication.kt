package com.test.test_task

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@Configuration
@EnableJpaRepositories("com.test.test_task.bot.repo")
class TestTaskApplication

fun main(args: Array<String>) {
	runApplication<TestTaskApplication>(*args)
}



