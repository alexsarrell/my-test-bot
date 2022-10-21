package com.test.test_task.bot.dto

data class QuestionDto(val text: String, val answer: AnswerDto, val wrongAnswers: List<AnswerDto>)