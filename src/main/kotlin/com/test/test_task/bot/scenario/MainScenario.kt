package com.test.test_task.bot.scenario

import com.justai.jaicf.activator.caila.caila
import com.justai.jaicf.builder.createModel
import com.justai.jaicf.model.scenario.Scenario
import com.test.test_task.bot.configuration.BotConfiguration
import org.springframework.stereotype.Component

@Component

class MainScenario(
    private val botConfiguration: BotConfiguration,
    private val participationScenario: ParticipationScenario
    ): Scenario {


    override val model = createModel {
        append(context = "ParticipationScenario", participationScenario)
        state("start") {
            activators {
                regex("/start")
                intent("Hello")
            }
            action {
                reactions.run {
                    image(botConfiguration.helloImageUrl)
                    sayRandom(
                        "Hello! Welcome to the Kotlin tournament!",
                        "Hi there! Welcome to the Kotlin joust!"
                    )
                    buttons(
                        "How can I participate?",
                        "What is going on here?"
                    )
                }
            }
        }

        state("howToParticipate") {
            activators {
                regex("How can I participate\\?")
            }

            action {
                reactions.run{
                    say("To participate, fill out our form")
                    say("Do you want to participate?")
                    buttons(
                        "Yes, i want!",
                        "No, maybe another time"
                    )
                }
            }
            state("iWant"){
                activators {
                    regex("Yes, i want!")
                }
                action {
                    reactions.go("/ParticipationScenario/participation", callbackState = "/start")
                }
            }
        }

        state("bye") {
            activators {
                intent("Bye")
            }

            action {
                reactions.sayRandom(
                    "See you soon!",
                    "Bye-bye!"
                )
                reactions.image(botConfiguration.byeImageUrl)
            }
        }

        state("smalltalk", noContext = true) {
            activators {
                anyIntent()
            }

            action(caila) {
                activator.topIntent.answer?.let { reactions.say(it) } ?: reactions.go("/fallback")
            }
        }

        fallback {
            reactions.sayRandom(
                "Sorry, I didn't get that...",
                "Sorry, could you repeat please?"
            )
        }
    }
}