package com.test.test_task.bot.scenario

import com.justai.jaicf.builder.createModel
import com.justai.jaicf.channel.telegram.telegram
import com.justai.jaicf.model.scenario.Scenario
import com.test.test_task.bot.dto.RespondentDto
import com.test.test_task.bot.service.RespondentService
import org.springframework.stereotype.Component

@Component
class ParticipationScenario(private val testScenario: TestScenario,
                            private val respondentService: RespondentService) : Scenario {
    private lateinit var respondentDTO: RespondentDto
    private var respondentName = ""
    private var respondentExperience = 0
    override val model = createModel {
        append(context = "TestScenario", testScenario)
        state("participation", modal = true){
            action {
                reactions.telegram?.go("/ParticipationScenario/participation/name")
            }
            state("name", modal = true){
                action{
                    reactions.telegram?.say("Great! At first, enter your name")
                }
                state("enterName", modal = true){
                    activators {
                        catchAll()
                    }
                    action {
                        respondentName = request.telegram?.input.toString()
                        reactions.telegram?.go("/ParticipationScenario/participation/experience")
                    }
                }
            }
            state("experience", modal = true){
                action{
                    reactions.telegram?.say("Good! Now enter your experience")
                }
                state("enterExp", modal = true){
                    activators {
                        catchAll()
                    }
                    action {
                        var isValid = true
                        try{
                            respondentExperience = request.telegram?.input!!.toInt()
                        }catch (formatEx: NumberFormatException){
                            reactions.telegram?.say("Please, enter the valid number of years")
                            isValid = false
                            reactions.telegram?.changeState("/ParticipationScenario/participation/experience")
                        }
                        if(isValid){
                            reactions.telegram?.run{
                                say("Great! Is that right?")
                                say("Your name is: ${respondentName}, and your experience is: " +
                                        "$respondentExperience")
                                buttons("Yes, that's right", "No, I want to edit")
                            }
                        }
                    }
                    state("yesRight", modal = true){
                        activators {
                            regex("Yes, that's right")
                        }
                        action {
                            reactions.telegram?.go("/ParticipationScenario/participation/continue")
                        }
                    }
                    state("noEdit", modal = true){
                        activators {
                            regex("No, I want to edit")
                        }
                        action {
                            reactions.telegram?.say("Okay!")
                            respondentExperience = 0
                            respondentName = ""
                            reactions.telegram?.go("/ParticipationScenario/participation/name")
                        }
                    }
                }
            }
            state("continue", modal = true){
                action {
                    reactions.telegram?.say("Wonderful! Registration is complete, click the \"Start\" button when you are ready to start!")
                    reactions.telegram?.buttons("Start")
                }
                state("startTest", modal = true){
                    activators {
                        regex("Start")
                    }
                    action {
                        reactions.telegram?.go("/TestScenario/test", callbackState = "/ParticipationScenario/participation/goMain")
                    }
                }
            }
            state("goMain"){
                action{
                    respondentDTO = try{
                        RespondentDto(respondentName, respondentExperience, context.result as Int)
                    } catch (ex: NumberFormatException){
                        RespondentDto(respondentName, respondentExperience, 0)
                    }
                    respondentService.save(respondentDTO)
                }
            }
        }
    }
}