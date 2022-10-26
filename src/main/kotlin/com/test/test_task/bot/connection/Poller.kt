package com.test.test_task.bot.connection

import com.test.test_task.bot.configuration.BotApi
import com.justai.jaicf.channel.jaicp.JaicpPollingConnector
import com.justai.jaicf.channel.telegram.TelegramChannel
import com.test.test_task.bot.configuration.BotConfiguration
import com.test.test_task.bot.scenario.MainScenario
import com.test.test_task.bot.scenario.ParticipationScenario
import com.test.test_task.bot.scenario.TestScenario
import com.test.test_task.bot.service.RespondentService
import com.test.test_task.bot.service.TestService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class Poller(private val testService: TestService,
             private val respondentService: RespondentService,
    private val botConfiguration: BotConfiguration
): ApplicationRunner, CoroutineScope {
    override val coroutineContext = Dispatchers.Default

    override fun run(args: ApplicationArguments?) {
        launch {
            JaicpPollingConnector(
                getBotApi(testService, respondentService, botConfiguration),
                accessToken = botConfiguration.accessToken,
                channels = listOf(TelegramChannel)
            ).runBlocking()
        }
    }
    companion object{
        private fun getBotApi(testService: TestService, respondentService: RespondentService, botConfiguration: BotConfiguration) : BotApi{
            val testScenario = TestScenario(testService)
            val participationScenario = ParticipationScenario(testScenario, respondentService)
            val mainScenario = MainScenario(
                botConfiguration, participationScenario)
            return BotApi(
                mainScenario, participationScenario = participationScenario,
                testScenario = testScenario, botConfiguration)
        }
    }
}
