package com.test.test_task.bot.scenario

import com.justai.jaicf.builder.createModel
import com.justai.jaicf.model.scenario.Scenario
import com.test.test_task.bot.configuration.BotConfiguration

class MainScenario(private val botConfiguration: BotConfiguration): Scenario {
    override val model = createModel {

    }
}