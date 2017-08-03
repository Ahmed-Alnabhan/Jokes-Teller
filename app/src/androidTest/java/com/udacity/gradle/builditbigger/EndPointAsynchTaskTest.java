package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Ahmed on 8/3/2017.
 */

@RunWith(AndroidJUnit4.class)
public class EndPointAsynchTaskTest implements OnReadingJokeComplete {
    private String result;
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testClick() {
        onView(withId(R.id.btn_display_joke)).perform(click());
    }

    @Test
    public void testAsyncTask() {
        try {
            MainActivity mainActivity = new MainActivity();
            EndpointsAsynchTask endpointsAsynchTask = new EndpointsAsynchTask(mainActivity.getApplicationContext(), this);
            endpointsAsynchTask.execute();
            assertTrue(!result.isEmpty());
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readJokeComplete(String joke) {
        result = joke;
    }
}
