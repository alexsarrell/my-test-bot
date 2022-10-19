package com.test.test_task.bot.scenario

import com.justai.jaicf.activator.regex.regex
import com.justai.jaicf.builder.createModel
import com.justai.jaicf.model.scenario.Scenario
import com.justai.jaicf.model.scenario.ScenarioModel
import com.test.test_task.bot.entity.Respondent
import org.springframework.stereotype.Component

@Component
class ParticipationScenario : Scenario {
    private var respondent: Respondent = Respondent(0, null, null, 0)
    override val model = createModel {
        state("name"){
            action{
                reactions.say("Great! At first, enter your name")
            }
            state("enterName"){
                activators {
                    catchAll()
                }
                action {
                    respondent.respondentName = request.input
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
                    respondent.respondentExperience = request.input.toInt()
                    reactions.run{
                        say("Wonderful! Registration is complete, click the \"Start\" button when you are ready to start!")
                        buttons("Start")
                    }
                }
            }
        }
    }
}