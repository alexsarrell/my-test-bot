package com.test.test_task.bot.scenario

import com.justai.jaicf.builder.createModel
import com.justai.jaicf.model.scenario.Scenario
import com.test.test_task.bot.service.TestService
import org.springframework.stereotype.Component

@Component
class TestScenario(private val testService: TestService) : Scenario {
    private var scope: Int = 0
    override val model = createModel {
        state("test"){
            action {
                reactions.go("/TestScenario/test/question")
            }
            state("question"){
                action {
                    reactions.say("Nice! The first question is: ")
                }
            }
        }

        state("end"){
            action {
                reactions.goBack(5)
            }
        }
    }
}