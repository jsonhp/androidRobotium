package com.apps.jsonhp.roboandroid.test;

import android.test.ActivityInstrumentationTestCase2;

import com.apps.jsonhp.roboandroid.Main2Activity;
import com.robotium.solo.Solo;

/**
 * Created by jeisson_herrera on 12/04/16.
 */
public class Main2ActivityTest extends ActivityInstrumentationTestCase2<Main2Activity> {

    private Solo solo;

    public Main2ActivityTest() {
        super(Main2Activity.class);
    }

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testExample() throws Exception {
        // check that we have the right activity
        solo.assertCurrentActivity("wrong activity", Main2Activity.class);
    }

}