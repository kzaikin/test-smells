/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package completeness.forgotten_option;

import coffee.ElectricHeater;
import org.junit.Test;
import sample.Good;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@Good("Both true and false results for isHot() are checked")
public class GoodHeaterTest {

    ElectricHeater heater = new ElectricHeater();

    @Test public void heaterIsOff_byDefault() {
        assertThat(heater.isHot(), is(false));
    }

    @Test public void brew_turnsHeaterOn() {
        heater.on();
        assertThat(heater.isHot(), is(true));
    }
}
