package com.test.test_task.bot.scenario

import com.justai.jaicf.builder.createModel
import com.justai.jaicf.model.scenario.Scenario
import com.test.test_task.bot.dto.RespondentDTO
import com.test.test_task.bot.model.DtoToEntity
import com.test.test_task.bot.repo.RespondentsRepo
import org.springframework.stereotype.Component

@Component
class ParticipationScenario(private val testScenario: TestScenario,
                            private val respondentsRepo: RespondentsRepo) : Scenario {
    private lateinit var respondentDTO: RespondentDTO
    private var respondentName = ""
    private var respondentExperience = 0
    override val model = createModel {
        append(context = "TestScenario", testScenario)
        state("name"){
            action{
                reactions.say("Great! At first, enter your name")
            }
            state("enterName"){
                activators {
                    catchAll()
                }
                action {
                    respondentDTO.respondentName = request.input
                    reactions.go("/experience")
                }
            }
        }
        state("experience"){
            action{
                reactions.say("Good! Now enter your experience")
            }
            state("enterExp"){
                activators {
                    catchAll()
                }
                action {
                    respondentDTO.respondentExperience = request.input.toInt()
                    reactions.run{
                        say("Great! Is that right?")
                        say("Your name is: ${respondentDTO.respondentName},\nand your experience is:" +
                                "${respondentDTO.respondentExperience}")
                        buttons("Yes, that's right", "No, I want to edit")
                    }
                }
                state("yesRight"){
                    activators {
                        regex("Yes, that's right")
                    }
                    action {
                        reactions.go("/continue")
                    }
                }
                state("noEdit"){
                    activators {
                        regex("No, I want to edit")
                    }
                    action {
                        reactions.say("Okay!")
                        respondentExperience = 0
                        respondentName = ""
                        reactions.go("/name")
                    }
                }
            }
        }
        state("continue"){
            action {
                reactions.say("Wonderful! Registration is complete, click the \"Start\" button when you are ready to start!")
                reactions.buttons("Start")
            }
            state("start"){
                activators {
                    regex("Start")
                }
                action {
                    reactions.go("/TestScenario/test", callbackState = "/goMain")
                }
            }
        }
        state("goMain"){
            action{
                respondentDTO = try{
                    RespondentDTO(respondentName, respondentExperience, context.result as Int)
                } catch (ex: NumberFormatException){
                    RespondentDTO(respondentName, respondentExperience, 0)
                }
                val respondent = DtoToEntity.createEntityFromDto(respondentDTO)
                respondentsRepo.save(respondent)
            }
        }
    }
}