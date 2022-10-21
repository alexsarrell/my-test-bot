package com.test.test_task.bot.service

import com.test.test_task.bot.dto.RespondentDto

interface RespondentService {
    fun getAll() : List<RespondentDto>
    fun save(respondentDto: RespondentDto)
}