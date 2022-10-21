package com.test.test_task.bot.repo

import com.test.test_task.bot.entity.AnswerEntity
import org.springframework.data.repository.CrudRepository

interface AnswerRepo : CrudRepository<AnswerEntity, Long>