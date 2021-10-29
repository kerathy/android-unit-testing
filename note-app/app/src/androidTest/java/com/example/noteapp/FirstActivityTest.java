package com.example.noteapp;

import android.widget.Button;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import junit.framework.TestCase;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.instanceOf;

@RunWith(AndroidJUnit4.class)
public class FirstActivityTest {

    @Rule
    public IntentsTestRule<FirstActivity> firstActivityIntentsTestRule = new IntentsTestRule<>(FirstActivity.class);

    @Test
    public void test_addNoteButton_shouldHaveValidText() {
        FirstActivity firstActivity = firstActivityIntentsTestRule.getActivity();
        Assert.assertNotNull(firstActivity);

        Button addNoteButton = firstActivity.findViewById(R.id.add_note_btn);
        Assert.assertNotNull(addNoteButton);
        Assert.assertThat(addNoteButton, instanceOf(Button.class));

        Assert.assertEquals(addNoteButton.getText().toString(), "Add Note");
    }

    @Test
    public void test_add_note_scenario() {
        onView(withId(R.id.edit_text_note_title)).perform(typeText("Enter Note Title"));
        onView(withId(R.id.edit_text_note_description)).perform(typeText("Enter Note Description"));
        closeSoftKeyboard();
        onView(withId(R.id.add_note_btn)).perform(click());
    }

    @Test
    public void test_nav_add_note_activity() {
        ActivityScenario<FirstActivity> launch = ActivityScenario.launch(FirstActivity.class);
        onView(withId(R.id.add_note_btn)).perform(click());
        onView(withId(R.id.add_note_activity)).check(matches(isDisplayed()));

    }


}