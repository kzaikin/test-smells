/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package readability.code_wall;

import java.util.Map;

class Reporter {
    private Adapter adapter;

    Reporter(Adapter adapter) {
        this.adapter = adapter;
    }

    void logGrouppedEvent(String group, String event, Map<String, String> params) {
        adapter.reportEvent(group, "{\"event1\":{\"param1\":\"val1\",\"param2\":\"val2\"}}");
    }
}
