package com.test.test_task.bot.entity


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Respondent(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var respondentId: Long,
    var respondentName: String? = null,
    var respondentExperience: Int? = null,
    var respondentResult: Int
)