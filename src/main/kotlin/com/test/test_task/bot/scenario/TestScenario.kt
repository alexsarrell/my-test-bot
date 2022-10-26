package com.test.test_task.bot.scenario

import com.justai.jaicf.builder.createModel
import com.justai.jaicf.channel.telegram.telegram
import com.justai.jaicf.model.scenario.Scenario
import com.test.test_task.bot.service.TestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Scope
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Component
import javax.servlet.ServletContext

@Component
@Scope("prototype")
class TestScenario(testService: TestService) : Scenario {
    private var scope: Int = 0
    private val test = testService.findById(1)
    private val questions = test.questions
    private var questionNumber = 0
    override val model = createModel {
        state("test"){
            action {
                reactions.telegram?.go("/TestScenario/test/question")
            }
            state("question"){
                action {
                    if(questionNumber < questions.size){
                        reactions.telegram?.say("Great! The next question is: ${questions[questionNumber].text}")
                        if(questions[questionNumber].imageUrl != null){
                            reactions.telegram?.image(questions[questionNumber].imageUrl!!)
                        }
                        for(answer in questions[questionNumber].wrongAnswers){
                            if(answer.text.length < 60){
                                reactions.telegram?.buttons(answer.text)
                            }
                            else{
                                reactions.telegram?.buttons(answer.text.substring(0, 60))
                            }
                        }
                    }
                    else{
                        val percents = (scope.toFloat()/(questions.size.toFloat()/100)).toInt()

                        reactions.telegram?.say("The test is complete! Your result is: $percents%, " +
                                "$scope/${questions.size} answers is right")
                        reactions.telegram?.go("/TestScenario/end")
                    }
                }
                state("answer"){
                    activators {
                        catchAll()
                    }
                    action {
                        if(questions[questionNumber].answer.text.startsWith(request.telegram?.input!!)){
                            reactions.telegram?.say("The right answer!")
                            scope++
                            questionNumber++
                            reactions.telegram?.go("/TestScenario/test/question")
                        }
                        else{
                            reactions.telegram?.say("The answer is wrong...")
                            questionNumber++
                            reactions.telegram?.go("/TestScenario/test/question")
                        }
                    }
                }
            }
        }

        state("end"){
            action {
                reactions.telegram?.goBack(scope)
            }
        }
    }
}