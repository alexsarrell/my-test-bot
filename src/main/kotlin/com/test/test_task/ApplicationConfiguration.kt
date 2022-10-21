package com.test.test_task
import com.justai.jaicf.BotEngine
import com.justai.jaicf.activator.caila.CailaIntentActivator
import com.justai.jaicf.activator.caila.CailaNLUSettings
import com.justai.jaicf.activator.regex.RegexActivator
import com.justai.jaicf.channel.jaicp.logging.JaicpConversationLogger
import com.justai.jaicf.logging.Slf4jConversationLogger
import com.test.test_task.bot.configuration.BotConfiguration
import com.test.test_task.bot.scenario.MainScenario
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


class ApplicationConfiguration {


  /*@Bean
    fun botApi(
      mainScenario: MainScenario,
      botConfiguration: BotConfiguration
  )
    = BotEngine(scenario = mainScenario,
    activators = arrayOf(RegexActivator, createCailaForToken(botConfiguration.accessToken)),
    conversationLoggers = arrayOf(
    JaicpConversationLogger(botConfiguration.accessToken),
    Slf4jConversationLogger()
    ))
    companion object{
        private fun createCailaForToken(token: String) = CailaIntentActivator.Factory(CailaNLUSettings(token))
    }*/
}