package com.test.test_task.bot.model

import com.test.test_task.bot.dto.RespondentDTO
import com.test.test_task.bot.entity.Respondent

class DtoToEntity {
    companion object{
        fun createDtoFromEntity(respondent: Respondent) : RespondentDTO {
            return RespondentDTO(
                respondent.respondentName,
                respondent.respondentExperience,
                respondent.respondentResult)
        }
        fun createEntityFromDto(respondentDto: RespondentDTO) : Respondent {
            return Respondent(
                0,
                respondentDto.respondentName,
                respondentDto.respondentExperience,
                respondentDto.respondentResult)
        }
    }
}