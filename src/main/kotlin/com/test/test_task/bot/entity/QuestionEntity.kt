package com.test.test_task.bot.entity

import javax.persistence.*

@Entity(name = "question")
class QuestionEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    val id: Long,
    @Column(name = "image_url")
    val imageUrl: String?,
    val questionText: String,
    @ManyToMany(mappedBy = "questions")
    val tests: List<TestEntity>,
    @OneToOne
    @JoinColumn(name = "answer_id", referencedColumnName = "answer_id")
    val answer: AnswerEntity,
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "question_answer",
        joinColumns = [JoinColumn(name = "question_id")],
        inverseJoinColumns = [JoinColumn(name = "answer_id")])
    val wrongAnswers: List<AnswerEntity>) {
}