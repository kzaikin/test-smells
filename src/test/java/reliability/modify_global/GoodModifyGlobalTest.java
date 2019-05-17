/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package reliability.modify_global;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import sample.NotSoGood;

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
    @NotSoGood("Global system settings are modified but are set to original value afterwards. " +
            "Best option is alter the system not to have a global mutable state.")
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
