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
public class ModifyGlobalTest {
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
    }

    // Please note this test is green when run alone and is red when run after another test
    @Test
    public void firstStartIsFalseByDefault() {
        assertThat(status.isFirstStart(), is(false));
    }
}
