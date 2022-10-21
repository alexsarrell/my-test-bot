package com.test.test_task.bot.service.impl

import com.test.test_task.bot.dto.AnswerDto
import com.test.test_task.bot.dto.QuestionDto
import com.test.test_task.bot.dto.TestDto
import com.test.test_task.bot.entity.AnswerEntity
import com.test.test_task.bot.entity.QuestionEntity
import com.test.test_task.bot.entity.TestEntity
import com.test.test_task.bot.repo.TestRepo
import com.test.test_task.bot.service.TestService
import org.springframework.stereotype.Service

@Service
class TestServiceImpl(private val testRepo: TestRepo) : TestService {
    override fun findAll(): List<TestDto> {
        return testRepo.findAll().map {
            it.toDto()
        }
    }

    private fun TestEntity.toDto() = TestDto(
        testName = this.testName,
        questions = this.questions.map {
            it.toDto()
        }
    )
    private fun QuestionEntity.toDto() = QuestionDto(
        text = this.questionText,
        answer = AnswerDto(
            text = this.answer.answerText
        ),
        wrongAnswers = this.wrongAnswers.map {
            it.toDto()
        }
    )

    private fun AnswerEntity.toDto() = AnswerDto(
        text = this.answerText
    )

    override fun findById(id: Long): TestDto {
        return testRepo.findByTestId(id).toDto()
    }

    override fun findByName(name: String): List<TestDto> {
        return testRepo.findAllByTestName(name).map { it.toDto() }
    }
}