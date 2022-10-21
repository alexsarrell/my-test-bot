package com.test.test_task.bot.service.impl

import com.test.test_task.bot.dto.RespondentDto
import com.test.test_task.bot.entity.RespondentEntity
import com.test.test_task.bot.repo.RespondentRepo
import com.test.test_task.bot.service.RespondentService
import org.springframework.stereotype.Service

@Service
class RespondentServiceImpl(private val respondentRepo: RespondentRepo) : RespondentService{
    override fun getAll() : List<RespondentDto>{
        return respondentRepo.findAll().map {
           it.toDto()
        }
    }

    override fun save(respondentDto: RespondentDto) {
        respondentRepo.save(respondentDto.let{
            RespondentEntity(
                respondentName = it.respondentName,
                respondentExperience = it.respondentExperience,
                respondentResult = it.respondentResult
            )
        })
    }

    private fun RespondentEntity.toDto() : RespondentDto = RespondentDto(
        respondentName = this.respondentName,
        respondentExperience = this.respondentExperience,
        respondentResult = this.respondentResult
    )
}