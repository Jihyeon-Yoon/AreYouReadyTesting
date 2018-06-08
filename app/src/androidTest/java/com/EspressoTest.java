package com;


import android.support.test.espresso.Espresso;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.yjh.areyouready.InfoBookActivity;
import com.example.yjh.areyouready.InfoVolunteerActivity;
import com.example.yjh.areyouready.R;
import com.example.yjh.areyouready.Volunteer;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;

@RunWith(AndroidJUnit4.class)
public class EspressoTest {

    @Rule
    public ActivityTestRule<InfoVolunteerActivity> EspressoActivity
            =new ActivityTestRule<InfoVolunteerActivity>(InfoVolunteerActivity.class);

    @Test
    public  void clickAddNoteButton_opensAddNoteUi() throws  Exception{
        Espresso.onView(ViewMatchers.withId(R.id.btn_website)).perform(click());

    }

}
