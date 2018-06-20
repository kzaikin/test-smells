/*
 * Copyright (c) 2018
 */

package structure.repeating_setup;

import coffee.CoffeeMaker;
import coffee.Heater;
import coffee.Pump;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sample.Bad;
import sample.Good;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static utils.SystemOutMatcher.has;

public class ShortCoffeeMakerTest {

    @Mock private Heater heater;
    @Mock private Pump pump;

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private CoffeeMaker coffeeMaker;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        System.setOut(new PrintStream(output));
        coffeeMaker = new CoffeeMaker(heater, pump);
    }

    @Good
    @Test public void brew_makesCoffee() {
        coffeeMaker.brew();
        assertThat(output, has(CoffeeMaker.COFFEE));
    }

    @Good
    @Test public void noBrew_noCoffee() {
        assertThat(output, not(has(CoffeeMaker.COFFEE)));
    }
}
