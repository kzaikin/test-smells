/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package speed.unnecessary_robolectric;

import coffee.CoffeeMaker;
import coffee.Heater;
import coffee.Pump;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import sample.Bad;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static utils.SystemOutMatcher.has;

@Bad("Using RobolectricTestRunner when no android")
@RunWith(RobolectricTestRunner.class)
public class RobolectricCoffeeMakerTest {
    @Mock Heater heater;
    @Mock Pump pump;

    ByteArrayOutputStream output = new ByteArrayOutputStream();
    CoffeeMaker coffeeMaker;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        System.setOut(new PrintStream(output));
        coffeeMaker = new CoffeeMaker(heater, pump);
    }

    @Test public void brew_makesCoffee() {
        coffeeMaker.brew();
        assertThat(output, has(CoffeeMaker.COFFEE));
    }
}
