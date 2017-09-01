package com.saira.appy;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class InstrumentedTests {

    /** check the name of the app **/
    @Test
    public void useAppContext() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.saira.appy", appContext.getPackageName());
    }

    /** check if the Question is displayed at the start
     * on the Play Screen after clicking the Play button **/
    @Test
    public void clickDisplayPlayQuestion() {
        onView(withId(R.id.buttonPlay)).perform(click());

        onView(withId(R.id.question2)).check(matches(withText(containsString("0 + 0"))));
    }

    /** check if the answer is set to the default at the start
     * on the Play Screen after clicking the Play button **/
    @Test
    public void clickDisplayPlayScore() {
        onView(withId(R.id.buttonPlay)).perform(click());

        onView(withId(R.id.answer)).check(matches(withText(containsString("= ?"))));
    }

    /** check whether the Score screen is displayed after
     * clicking the Score button **/
    @Test
    public void clickDisplayScore() {
        onView(withId(R.id.buttonScore)).perform(click());

        onView(withId(R.id.score)).check(matches(withText(containsString("SCORE"))));
    }

    /** check whether the How To Play screen is displayed after
     * clicking the How To Play button **/
    @Test
    public void clickHowTo() {
        onView(withId(R.id.buttonHowTo)).perform(click());

        onView(withId(R.id.howToPlay)).check(matches(withText(containsString("HOW TO PLAY"))));
    }

    /** check whether the How To Play screen displays the how text #1 **/
    @Test
    public void clickHowToRules() {
        onView(withId(R.id.buttonHowTo)).perform(click());

        onView(withId(R.id.how)).check(matches(withText(containsString("@string/how"))));
    }

    /** check whether the How To Play screen displays the how text #2 **/
    @Test
    public void clickHowToRules2() {
        onView(withId(R.id.buttonHowTo)).perform(click());

        onView(withId(R.id.how2)).check(matches(withText(containsString("@string/how2"))));
    }

    /** check whether the How To Play screen displays the how text #3 **/
    @Test
    public void clickHowToRules3() {
        onView(withId(R.id.buttonHowTo)).perform(click());

        onView(withId(R.id.how3)).check(matches(withText(containsString("@string/how3"))));
    }
}
