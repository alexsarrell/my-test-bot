package com.test.test_task.bot.repo

import com.test.test_task.bot.entity.Respondent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RespondentsRepo : JpaRepository<Respondent, Long>