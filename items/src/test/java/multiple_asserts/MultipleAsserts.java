package multiple_asserts;

import org.junit.Test;
import sample.Bad;
import sample.Good;
import sample.NotSoGood;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;
import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 */
public class MultipleAsserts {
    static final Map<String, List<String>> REFERENCE_MAP = of(
            "foo", asList("foo1", "foo2"),
            "everyEntry_asExpected", asList("bar1", "bar2")
    );
    CodeWallComponent component = new CodeWallComponent();

    @Bad
    @Test public void everyItem_asExpected() {
        Map<String, List<String>> map = component.mapOfArrays();
        assertEquals(2, map.size());
        assertTrue(map.containsKey("foo"));
        assertTrue(map.get("foo").contains("foo1"));
        assertTrue(map.get("foo").contains("foo2"));
        assertTrue(map.containsKey("everyEntry_asExpected"));
        assertTrue(map.get("everyEntry_asExpected").contains("bar1"));
        assertTrue(map.get("everyEntry_asExpected").contains("bar2"));
    }

    @NotSoGood
    @Test public void everyEntry_asExpected() {
        Map<String, List<String>> map = component.mapOfArrays();
        assertThat(map.keySet(), containsInAnyOrder("foo", "everyEntry_asExpected"));
        assertThat(map, allOf(
                hasEntry(is("foo"), contains("foo1", "foo2")),
                hasEntry(is("everyEntry_asExpected"), contains("bar1", "bar2"))));
    }

    @Good
    @Test public void result_asExpected() {
        Map<String, List<String>> map = component.mapOfArrays();
        assertThat(map, equalTo(REFERENCE_MAP));
    }

    static class CodeWallComponent {
        Map<String, List<String>> mapOfArrays() {
            HashMap<String, List<String>> result = new HashMap<>();
            result.put("foo", asList("foo1", "foo2"));
            result.put("everyEntry_asExpected", asList("bar1", "bar2"));
            return result;
        }
    }
}
