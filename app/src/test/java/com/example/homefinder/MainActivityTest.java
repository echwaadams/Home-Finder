package com.example.homefinder;

import static org.junit.Assert.assertTrue;

import android.content.Intent;
import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private SignupActivity activity;

    @Before
    public void setUp() throws Exception{
        activity = Robolectric.buildActivity(SignupActivity.class)
                .create()
                .resume()
                .get();
    }
    @org.testng.annotations.Test
    public void validateEditTextViewContent(){
        EditText emailEditText = activity.findViewById(R.id.emailEditText);
        assertTrue("Your Email".equals(emailEditText.getText().toString()));
    }
    @Test
    public void thirdActivityStarted(){
        activity.findViewById(R.id.signupButton).performClick();
        Intent expectedIntent = new Intent(activity, LoginActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
