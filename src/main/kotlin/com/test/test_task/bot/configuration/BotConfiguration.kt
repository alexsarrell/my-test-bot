package com.test.test_task.bot.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
data class BotConfiguration(
    @Value("\${bot.accessToken}")val accessToken: String,
    @Value("\${bot.helloImageUrl}")val helloImageUrl: String,
    @Value("\${bot.byeImageUrl}")val byeImageUrl: String
)