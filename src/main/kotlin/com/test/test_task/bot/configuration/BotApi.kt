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
import com.test.test_task.bot.scenario.TestScenario
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
class BotApi(
    mainScenario: MainScenario,
    participationScenario: ParticipationScenario,
    testScenario: TestScenario,
    botConfiguration: BotConfiguration
) : BotEngine(scenario = mainScenario append participationScenario append testScenario,
                activators = arrayOf(RegexActivator, createCailaForToken(botConfiguration.accessToken)),
                conversationLoggers = arrayOf(
                JaicpConversationLogger(botConfiguration.accessToken),
                Slf4jConversationLogger())) {
    companion object{
        private fun createCailaForToken(token: String) = CailaIntentActivator.Factory(CailaNLUSettings(token))
    }
}

