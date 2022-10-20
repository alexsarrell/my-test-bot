package com.test.test_task.bot.configuration

import com.justai.jaicf.BotEngine
import com.justai.jaicf.activator.caila.CailaIntentActivator
import com.justai.jaicf.activator.caila.CailaNLUSettings
import com.justai.jaicf.activator.regex.RegexActivator
import com.justai.jaicf.builder.append
import com.justai.jaicf.channel.jaicp.logging.JaicpConversationLogger
import com.justai.jaicf.logging.Slf4jConversationLogger
import com.test.test_task.bot.scenario.MainScenario
import com.test.test_task.bot.scenario.ParticipationScenario
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@ComponentScan("com.test.test_task.bot")
@EnableJpaRepositories("com.test.test_task.bot")
class ApplicationConfiguration (
    private val botConfiguration: BotConfiguration,
    private val participationScenario: ParticipationScenario
    ){
    @Bean
    fun mainScenario() : MainScenario {
        return MainScenario(botConfiguration, participationScenario)
    }
    @Bean
    fun botApi(
        mainScenario: MainScenario,
        participationScenario: ParticipationScenario
    ) = BotEngine(
        scenario = mainScenario append participationScenario,
        activators = arrayOf(RegexActivator, createCailaForToken(botConfiguration.accessToken)),
        conversationLoggers = arrayOf(
            JaicpConversationLogger(botConfiguration.accessToken),
            Slf4jConversationLogger())
    )
    companion object {
        private fun createCailaForToken(token: String) = CailaIntentActivator.Factory(CailaNLUSettings(token))

    }
}