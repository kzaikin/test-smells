/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package know_your_tools.inherit_for_verify;

import coffee.CoffeeMaker;
import coffee.Heater;
import coffee.Pump;
import org.junit.Test;
import sample.Good;

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
