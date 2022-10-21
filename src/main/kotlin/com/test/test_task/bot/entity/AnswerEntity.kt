package com.test.test_task.bot.entity

import javax.persistence.*

@Entity(name = "answer")
class AnswerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    val id: Long,
    val answerText: String,
    @OneToOne(mappedBy = "answer")
    val question: QuestionEntity,
    @ManyToMany(mappedBy = "wrongAnswers")
    var questions: List<QuestionEntity>
) {
}