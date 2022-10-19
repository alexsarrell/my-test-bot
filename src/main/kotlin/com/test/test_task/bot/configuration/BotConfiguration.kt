package com.test.test_task.bot.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Component
data class BotConfiguration(
    @Value("\${bot.accessToken}")val accessToken: String,
    @Value("\${bot.helloImageUrl}")val helloImageUrl: String,
    @Value("\${bot.byeImageUrl}")val byeImageUrl: String
)