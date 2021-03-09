package com.test.news.rules

import com.test.news.common.AdbCommands.ANIMATOR_DURATION
import com.test.news.common.AdbCommands.TRANSITION_ANIMATION_SCALE
import com.test.news.common.AdbCommands.WINDOW_ANIMATION_SCALE
import com.test.news.utils.toInt
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.io.IOException


class AnimationsRule : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                changeAnimationStatus(enable = false)
                try {
                    base.evaluate()
                } finally {
                    changeAnimationStatus(enable = true)
                }
            }
        }
    }

    @Throws(IOException::class)
    private fun changeAnimationStatus(enable: Boolean = true) {
        executeShellCommand(" $TRANSITION_ANIMATION_SCALE ${enable.toInt()}")
        executeShellCommand("$WINDOW_ANIMATION_SCALE ${enable.toInt()}")
        executeShellCommand("$ANIMATOR_DURATION ${enable.toInt()}")

    }
}
