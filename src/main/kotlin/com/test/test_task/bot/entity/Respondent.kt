package com.test.test_task.bot.entity


import javax.persistence.*

@Entity
@Table
class Respondent(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var respondentId: Long,
    var respondentName: String,
    var respondentExperience: Int,
    var respondentResult: Int
)