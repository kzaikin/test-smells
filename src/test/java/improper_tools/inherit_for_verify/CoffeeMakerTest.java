/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package improper_tools.inherit_for_verify;

import coffee.CoffeeMaker;
import coffee.ElectricHeater;
import coffee.Pump;
import org.junit.Test;
import sample.Bad;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class CoffeeMakerTest {

    Pump pump = mock(Pump.class);

    @Bad("A class extending ElectricHeater is used to verify if a method was called")
    @Test public void brew_turnsHeaterOn() {
        MyElectricHeater heater = new MyElectricHeater();
        CoffeeMaker coffeeMaker = new CoffeeMaker(heater, pump);
        coffeeMaker.brew();
        assertThat(heater.wasTurnedOn, is(true));
    }

    class MyElectricHeater extends ElectricHeater {
        private boolean wasTurnedOn;

        @Override
        public void on() {
            super.on();
            wasTurnedOn = true;
        }

        public boolean wasTurnedOn() {
            return this.wasTurnedOn;
        }
    }
}
