package com.test.test_task.bot.scenario

import com.justai.jaicf.builder.createModel
import com.justai.jaicf.channel.telegram.telegram
import com.justai.jaicf.model.scenario.Scenario
import com.test.test_task.bot.dto.RespondentDto
import com.test.test_task.bot.service.RespondentService
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope("prototype")
class ParticipationScenario(private val testScenario: TestScenario,
                            private val respondentService: RespondentService) : Scenario {
    var sessionsMap: HashMap<String, RespondentDto> = HashMap()
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
                        if(sessionsMap.containsKey(request.clientId)){
                            val respondentDTO: RespondentDto = sessionsMap[request.clientId]!!
                            respondentDTO.respondentName = request.telegram?.input!!
                        }
                        else{
                            sessionsMap[request.clientId] = RespondentDto(request.telegram?.input!!, 0, 0)
                        }
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
                            if(sessionsMap.containsKey(request.clientId)){
                                val respondentDTO: RespondentDto = sessionsMap[request.clientId]!!
                                respondentDTO.respondentExperience = request.telegram?.input!!.toInt()
                            }
                        }catch (formatEx: NumberFormatException){
                            reactions.telegram?.say("Please, enter the valid number of years")
                            isValid = false
                            reactions.telegram?.changeState("/ParticipationScenario/participation/experience")
                        }
                        if(isValid){
                            reactions.telegram?.run{
                                say("Great! Is that right?")
                                say("Your name is: ${sessionsMap[request.clientId]?.respondentName}, and your experience is: " +
                                        "${sessionsMap[request.clientId]?.respondentExperience}")
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

                    try{
                        sessionsMap[request.telegram?.clientId!!]!!.respondentResult = context.result as Int
                    } catch (ex: NumberFormatException){
                        sessionsMap[request.telegram?.clientId!!]!!.respondentResult = 0
                    }
                    respondentService.save(sessionsMap[request.telegram?.clientId!!]!!)
                    sessionsMap.remove(request.telegram?.clientId!!)
                }
            }
        }
    }
}