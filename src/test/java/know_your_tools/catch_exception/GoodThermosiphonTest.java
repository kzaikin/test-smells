/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package know_your_tools.catch_exception;

import coffee.Heater;
import coffee.Pump;
import coffee.Reservoir;
import coffee.Thermosiphon;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import sample.Good;
import sample.NotSoGood;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GoodThermosiphonTest {

    Reservoir reservoir = mock(Reservoir.class);

    public GoodThermosiphonTest() {
        when(reservoir.isEmpty()).thenReturn(true);
    }

    @NotSoGood("Test expects exception with @Test(expected) parameter any time during the test execution. " +
            "If Thermosiphon constructor throws an IllegalStateException, test would succeed which is not an expected behavior")
    @Test(expected = IllegalStateException.class)
    public void throw_whenNoWater_withExpected() {
        Pump pump = new Thermosiphon(mock(Heater.class), reservoir);
        pump.pump();
    }

    public @Rule ExpectedException thrown = ExpectedException.none();

    @Good("Test expects for exception with an ExpectedException rule at exact line")
    @Test public void throw_whenNoWater_withRule() {
        Pump pump = new Thermosiphon(mock(Heater.class), reservoir);
        thrown.expect(IllegalStateException.class);
        pump.pump();
    }
}
