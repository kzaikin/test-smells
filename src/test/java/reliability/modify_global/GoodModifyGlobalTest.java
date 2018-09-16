/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package reliability.modify_global;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import sample.Bad;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class GoodModifyGlobalTest {
    StaticApplicationStatus status;

    @Before
    public void setUp() {
        status = new StaticApplicationStatus();
    }

    @Test
    @Bad("Global system settings are modified and are never set to original value." +
            "Test execution order affects test results!")
    public void firstStartIsReadFromSharedPreferences() {
        StaticApplicationStatus.isFirstStart = true;

        assertThat(status.isFirstStart(), is(true));

        StaticApplicationStatus.isFirstStart = false;
    }

    // If this test is run alone then it is red.
    // If it is run after firstStartIsReadFromSharedPreferences then it is red. That's no good.
    @Test
    public void firstStartIsFalseByDefault() {
        assertThat(status.isFirstStart(), is(false));
    }
}
