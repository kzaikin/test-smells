/*
 * Copyright (c) 2018
 */

package structure.repeating_setup;

import coffee.CoffeeMaker;
import coffee.Heater;
import coffee.Pump;
import org.junit.Test;
import org.mockito.Mock;
import sample.Bad;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static utils.SystemOutMatcher.has;

public class CoffeeMakerTest {

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Bad
    @Test public void brew_makesCoffee() {
        Heater heater = mock(Heater.class);
        Pump pump = mock(Pump.class);
        System.setOut(new PrintStream(output));
        CoffeeMaker coffeeMaker = new CoffeeMaker(heater, pump);
        coffeeMaker.brew();
        assertThat(output, has(CoffeeMaker.COFFEE));
    }

    @Bad
    @Test public void noBrew_noCoffee() {
        Heater heater = mock(Heater.class);
        Pump pump = mock(Pump.class);
        System.setOut(new PrintStream(output));
        CoffeeMaker coffeeMaker = new CoffeeMaker(heater, pump);
        assertThat(output, not(has(CoffeeMaker.COFFEE)));
    }
}
