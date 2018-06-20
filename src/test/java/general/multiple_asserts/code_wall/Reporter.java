/*
 * Copyright (c) 2018
 */

package general.multiple_asserts.code_wall;

import java.util.Map;

public class Reporter {
    private Adapter adapter;

    public Reporter(Adapter adapter) {
        this.adapter = adapter;
    }

    public void logGrouppedEvent(String group, String event, Map<String, String> params) {
        adapter.reportEvent(group, "{\"event1\":{\"param1\":\"val1\",\"param2\":\"val2\"}}");
    }
}
