package com.udacity.gradle.builditbigger;

/*
 * Created by Mourad on 1/23/2018.
 */


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndpointAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;

import java.io.IOException;

/**
 * Created by kev on 3/21/16.
 */

@RunWith(AndroidJUnit4.class)
public class EndPointAsyncTaskTest {
    @Rule
    public final ActivityTestRule<MainActivity> mActivityActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testAsyncTaskLoadsJoke() throws Exception {

        // Assign
        EndpointAsyncTask testTask = new EndpointAsyncTask(mActivityActivityTestRule.getActivity());

        // Action
        testTask.execute();
        String joke = testTask.get();

        // Assert
        assertNotNull(joke);
        assertFalse(joke.isEmpty());
    }

}