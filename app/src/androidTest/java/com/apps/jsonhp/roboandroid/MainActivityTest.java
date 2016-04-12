package com.apps.jsonhp.roboandroid;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

/**
 * Created by jeisson_herrera on 12/04/16.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation());
        getActivity();
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testExample() throws Exception {
        //Unlock the lock screen
        solo.unlockScreen();
        // check that we have the right activity
        solo.assertCurrentActivity("wrong activity", MainActivity.class);
    }

}