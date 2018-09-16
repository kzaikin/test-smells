/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package know_your_tools.robolectric_shared_preferences;

import android.content.SharedPreferences;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import sample.Good;

import static android.content.Context.MODE_PRIVATE;
import static know_your_tools.robolectric_shared_preferences.ApplicationStatus.FIRST_START;
import static know_your_tools.robolectric_shared_preferences.ApplicationStatus.STATUS_PREFERENCES;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class GoodSharedPreferencesTest {
    SharedPreferences preferences = RuntimeEnvironment.application.getSharedPreferences(STATUS_PREFERENCES, MODE_PRIVATE);
    ApplicationStatus status;

    @Before
    public void setUp() {
        status = new ApplicationStatus(RuntimeEnvironment.application);
    }

    @Test
    @Good("Shared preferences are reset automatically when you use Robolectric")
    public void firstStartIsReadFromSharedPreferences() {
        preferences.edit().putBoolean(FIRST_START, true).apply();

        assertThat(status.isFirstStart(), is(true));
    }
}
