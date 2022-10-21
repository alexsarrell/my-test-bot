package com.test.test_task.bot.entity

import javax.persistence.*

@Entity(name = "test")
class TestEntity(
    @Id
    @Column(name = "test_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val testId: Long = 0,
    @Column(name = "test_name")
    val testName: String = "",
    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "test_question",
        joinColumns = [JoinColumn(name = "test_id")],
        inverseJoinColumns = [JoinColumn(name = "question_id")]
    )
    val questions: List<QuestionEntity>
)