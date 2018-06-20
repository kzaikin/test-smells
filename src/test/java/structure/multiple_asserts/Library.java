/*
 * Copyright (c) 2018
 */

package structure.multiple_asserts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

class Library {
    Map<String, List<String>> contents() {
        HashMap<String, List<String>> result = new HashMap<>();
        result.put("foo", asList("foo1", "foo2"));
        result.put("bar", asList("bar1", "bar2"));
        return result;
    }
}
