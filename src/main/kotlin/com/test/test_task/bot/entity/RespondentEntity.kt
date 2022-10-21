package com.test.test_task.bot.entity


import javax.persistence.*

@Entity(name = "respondent")
class RespondentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "respondent_id")
    var respondentId: Long = 0,
    @Column(name = "respondent_name")
    var respondentName: String,
    @Column(name = "respondent_experience")
    var respondentExperience: Int,
    @Column(name = "respondent_result")
    var respondentResult: Int
)