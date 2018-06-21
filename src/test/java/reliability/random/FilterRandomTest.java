/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package reliability.random;

import org.junit.Test;
import sample.Bad;

import java.util.List;

import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;
import static reliability.random.Generator.getFixedSizeCollection;

public class FilterRandomTest {
    private int SMALL_NUMBER = 10;

    @Bad("This test can be red or green depending on random number")
    @Test public void getFirst_returnsProperHead() {
        List<Integer> head = Filter.getFirst(SMALL_NUMBER,
                getFixedSizeCollection(Math.random() * 20));
        assertThat(head.size(), lessThanOrEqualTo(SMALL_NUMBER));
    }

}
