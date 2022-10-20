package com.test.test_task.bot.repo

import com.test.test_task.bot.entity.Respondent
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
interface RespondentsRepo : JpaRepository<Respondent, Long> {

}