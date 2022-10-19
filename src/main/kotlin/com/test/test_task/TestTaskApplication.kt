package com.test.test_task

import com.test.test_task.bot.configuration.ApplicationConfiguration
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class TestTaskApplication

fun main(args: Array<String>) {
	runApplication<TestTaskApplication>(*args)
	AnnotationConfigApplicationContext(ApplicationConfiguration::class.java)
}



