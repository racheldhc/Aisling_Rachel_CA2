package com.example.aisling_rachel_ca2

import androidx.test.platform.app.InstrumentationRegistry


import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * import androidx.test.ext.junit.runners.AndroidJUnit4
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
@RunWith(AndroidJUnit4::class)
@LargeTest
class HelloWorldEspressoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test fun listGoesOverTheFold() {
        onView(withText("Hello world!")).check(matches(isDisplayed()))
    }
}
 */