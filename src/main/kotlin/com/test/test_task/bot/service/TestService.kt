package com.test.test_task.bot.service

import com.test.test_task.bot.dto.TestDto

interface TestService {
    fun findAll() : List<TestDto>
    fun findById(id: Long) : TestDto
    fun findByName(name: String) : List<TestDto>
}