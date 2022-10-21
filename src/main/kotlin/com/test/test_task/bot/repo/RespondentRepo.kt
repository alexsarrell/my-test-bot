package com.test.test_task.bot.repo

import com.test.test_task.bot.entity.RespondentEntity
import org.springframework.data.repository.CrudRepository

interface RespondentRepo : CrudRepository<RespondentEntity, Long>