/*
 * Copyright (c) 2018
 */

package wrong_tools.inherit_for_verify;

import coffee.CoffeeMaker;
import coffee.ElectricHeater;
import coffee.Heater;
import coffee.Pump;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import sample.Bad;
import sample.Good;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GoodCoffeeMakerTest {

    Pump pump = mock(Pump.class);
    Heater heater = mock(Heater.class);
    CoffeeMaker coffeeMaker = new CoffeeMaker(heater, pump);

    @Good("Mockito.verify is used to check if a method was called")
    @Test public void brew_turnsHeaterOn() {
        coffeeMaker.brew();
        verify(heater).on();
    }
}
