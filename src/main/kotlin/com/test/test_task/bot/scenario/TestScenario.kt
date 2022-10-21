package com.test.test_task.bot.scenario

import com.justai.jaicf.builder.createModel
import com.justai.jaicf.model.scenario.Scenario
import com.test.test_task.bot.service.TestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Component
import javax.servlet.ServletContext

@Component
class TestScenario(testService: TestService) : Scenario {
    @Value("\${project-path}")
    lateinit var resourcesPath: String
    private var scope: Int = 0
    private val test = testService.findById(1)
    private val questions = test.questions
    private var questionNumber = 0
    override val model = createModel {
        state("test"){
            action {
                reactions.go("/TestScenario/test/question")
            }
            state("question"){
                action {
                    if(questionNumber < questions.size){
                        reactions.say("Great! The next question is: ${questions[questionNumber].text}")
                        if(questions[questionNumber].imageUrl != null){
                            val fileName = questions[questionNumber].imageUrl!!.replace("/", "\\")
                            reactions.image("$resourcesPath\\img$fileName")
                        }
                        for(answer in questions[questionNumber].wrongAnswers){
                            reactions.buttons(answer.text)
                        }
                    }
                    else{
                        reactions.say("The text is complete! Your result: ${(scope/(questions.size/100))}%, $scope/${questions.size} answers is right")
                        reactions.go("/TestScenario/end")
                    }
                }
                state("answer"){
                    activators {
                        catchAll()
                    }
                    action {
                        if(request.input == questions[questionNumber].answer.text){
                            reactions.say("The right answer!")
                            scope++
                            questionNumber++
                            reactions.go("/TestScenario/test/question")
                        }
                        else{
                            reactions.say("The answer is wrong...")
                            questionNumber++
                            reactions.go("/TestScenario/test/question")
                        }
                    }
                }
            }
        }

        state("end"){
            action {
                reactions.goBack(scope)
            }
        }
    }
}