/*
 * Copyright (c) 2018
 */

package structure.multiple_asserts;

import org.junit.Test;
import sample.Good;
import sample.NotSoGood;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class GoodLibraryTest {
    static final Map<String, List<String>> REFERENCE_CONTENTS = of(
            "foo", asList("foo1", "foo2"),
            "bar", asList("bar1", "bar2")
    );
    Library library = new Library();

    @NotSoGood
    @Test public void everyEntry_asExpected() {
        Map<String, List<String>> map = library.contents();
        assertThat(map.keySet(), containsInAnyOrder("foo", "bar"));
        assertThat(map, allOf(
                hasEntry(is("foo"), contains("foo1", "foo2")),
                hasEntry(is("bar"), contains("bar1", "bar2"))));
    }

    @Good
    @Test public void result_asExpected() {
        Map<String, List<String>> contents = library.contents();
        assertThat(contents, equalTo(REFERENCE_CONTENTS));
    }
}
