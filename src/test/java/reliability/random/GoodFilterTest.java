/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package reliability.random;

import org.junit.Test;
import sample.Good;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;
import static reliability.random.Generator.getFixedSizeCollection;

@Good("This class has individual tests for certain sizes")
public class GoodFilterTest {
    private int SMALL_NUMBER = 10;
    private int BIG_NUMBER = 500;

    @Test public void getFirst_returnsProperHead_fromSingletonList() {
        List<Integer> head = Filter.getFirst(SMALL_NUMBER,
                getFixedSizeCollection(1));
        assertThat(head.size(), lessThanOrEqualTo(SMALL_NUMBER));
    }

    // This test is always red letting us know getFirst has a flaw
    // which is not reliably detected by FilterRandomTest
    @Test public void getFirst_returnsProperHead_fromBigList() {
        List<Integer> head = Filter.getFirst(SMALL_NUMBER,
                getFixedSizeCollection(BIG_NUMBER));
        assertThat(head.size(), lessThanOrEqualTo(SMALL_NUMBER));
    }
}
