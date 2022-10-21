package com.test.test_task.bot.repo

import com.test.test_task.bot.entity.TestEntity
import org.springframework.data.repository.CrudRepository

interface TestRepo : CrudRepository<TestEntity, Long> {
    fun findByTestId(id: Long) : TestEntity
    fun findAllByTestName(name: String) : List<TestEntity>
}