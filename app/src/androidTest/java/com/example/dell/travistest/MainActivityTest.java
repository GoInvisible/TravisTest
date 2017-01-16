package com.example.dell.travistest;

import android.app.Instrumentation;
import android.support.test.espresso.intent.rule.IntentsTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class MainActivityTest extends Instrumentation {

    @Rule
    public IntentsTestRule<MainActivity> mActivityRule = new IntentsTestRule<>(
            MainActivity.class, true, true);

    @Test
    public void whenActivityStarted_MapIsProperlyDisplayed() {
        onView(withId(R.id.fab))
                .check(doesNotExist());
    }

    @Test
    public void whenPlaceItemOnListIsClicked_ArPlaceDetailsActivityIsStarted() {
        //when
        onView(withId(R.id.fab)).perform(click());

        //then
        intended(hasComponent(SecondActivity.class.getName()));
    }
}