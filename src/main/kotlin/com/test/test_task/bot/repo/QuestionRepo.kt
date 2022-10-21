package com.test.test_task.bot.repo

import com.test.test_task.bot.entity.QuestionEntity
import org.springframework.data.repository.CrudRepository

interface QuestionRepo : CrudRepository<QuestionEntity, Long>