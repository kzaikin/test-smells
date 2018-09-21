/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package completeness.forgotten_option;

import coffee.ElectricHeater;
import org.junit.Test;
import sample.Bad;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@Bad("Only true result for isHot() is checked")
public class HeaterTest {

    ElectricHeater heater = new ElectricHeater();

    @Test public void brew_turnsHeaterOn() {
        heater.on();
        assertThat(heater.isHot(), is(true));
    }
}
