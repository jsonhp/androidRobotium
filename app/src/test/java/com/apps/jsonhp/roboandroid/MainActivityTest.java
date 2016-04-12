package com.apps.jsonhp.roboandroid;

import android.content.Intent;
import android.os.Build;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by jeisson_herrera on 12/04/16.
 */

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {

    private MainActivity activity;
    TextView tvExample;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
        tvExample = (TextView) activity.findViewById(R.id.tvExample);
    }

    @Test
    public void validateTextViewContent() {
        assertNotNull("TextView could not be found", tvExample);
        assertTrue("TextView contains incorrect text", "Hola Mundo".equals(tvExample.getText().toString()));
    }

    @Test
    public void secondActivityStartedOnClick() {
        activity.findViewById(R.id.btnExample).performClick();

        // The intent we expect to be launched when a user clicks on the button
        Intent expectedIntent = new Intent(activity, Main2Activity.class);

        // An Android "Activity" doesn't expose a way to find out about activities it launches
        // Robolectric's "ShadowActivity" keeps track of all launched activities and exposes this information
        // through the "getNextStartedActivity" method.
        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();

        // Determine if two intents are the same for the purposes of intent resolution (filtering).
        // That is, if their action, data, type, class, and categories are the same. This does
        // not compare any extra data included in the intents
        assertTrue(actualIntent.filterEquals(expectedIntent));
        assertTrue("TextView contains incorrect text", "Hi JSon".equals(tvExample.getText().toString()));
    }

}