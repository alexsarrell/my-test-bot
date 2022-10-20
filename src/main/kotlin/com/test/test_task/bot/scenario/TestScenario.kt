package com.test.test_task.bot.scenario

import com.justai.jaicf.builder.createModel
import com.justai.jaicf.model.scenario.Scenario
import org.springframework.stereotype.Component

@Component
class TestScenario : Scenario {
    private var scope: Int = 0
    override val model = createModel {
        state("test"){
            state("question1"){

            }
            state("question2"){

            }
            state("question3"){

            }
            state("question4"){

            }
            state("question5"){

            }
            state("question6"){

            }
            state("question7"){

            }
            state("question8"){

            }
            state("question9"){

            }
            state("question10"){

            }
            state("question11"){

            }
            state("question12"){

            }
            state("question13"){

            }
            state("question14"){

            }
            state("question15"){

            }
            state("question16"){

            }
            state("question17"){

            }
            state("question18"){

            }
            state("question19"){

            }
            state("question20"){

            }
        }


        state("end"){
            action {
                reactions.goBack(5)
            }
        }
    }
}