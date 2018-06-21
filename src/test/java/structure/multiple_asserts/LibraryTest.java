package structure.multiple_asserts;

import org.junit.Test;
import sample.Bad;

import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class LibraryTest {
    Library library = new Library();

    @Bad
    @Test public void everyItem_asExpected() {
        Map<String, List<String>> map = library.contents();
        assertEquals(2, map.size());
        assertTrue(map.containsKey("foo"));
        assertTrue(map.get("foo").contains("foo1"));
        assertTrue(map.get("foo").contains("foo2"));
        assertTrue(map.containsKey("bar"));
        assertTrue(map.get("bar").contains("bar1"));
        assertTrue(map.get("bar").contains("bar2"));
    }
}
