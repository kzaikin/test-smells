/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package know_your_tools.catch_exception;

import coffee.Heater;
import coffee.Pump;
import coffee.Reservoir;
import coffee.Thermosiphon;
import org.junit.Test;
import sample.Bad;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ThermosiphonTest {

    Reservoir reservoir = mock(Reservoir.class);
    public ThermosiphonTest() {
        when(reservoir.isEmpty()).thenReturn(true);
    }

    @Bad("Test handles exception manually")
    @Test public void throw_whenNoWater() {
        try {
            Pump pump = new Thermosiphon(mock(Heater.class), reservoir);
            pump.pump();
        } catch (IllegalStateException e) {
            // should throw IllegalStateException when reservoir is empty
            return;
        }
        // it one forgets to fail, the test would succeed when no exception is thrown
        fail("no FireException");
    }
}
