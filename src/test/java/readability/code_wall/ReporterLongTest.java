/*
 * Copyright (c) 2018
 */

package readability.code_wall;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import sample.Bad;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReporterLongTest {

    @Bad
    @Test public void logGroupedEvent_createsValidJson() throws JSONException {
        Adapter adapter = mock(Adapter.class);
        Reporter reporter = new Reporter(adapter);
        Map<String, String> params = new HashMap<>();
        params.put("param1", "val1");
        params.put("param2", "val2");
        reporter.logGrouppedEvent("group1", "event1", params);
        ArgumentCaptor<String> jsonCaptor = ArgumentCaptor.forClass(String.class);
        verify(adapter).reportEvent(eq("group1"), jsonCaptor.capture());
        String json = jsonCaptor.getValue();
        JSONObject obj = new JSONObject(json);
        Assert.assertTrue("Event not found in json " + json, obj.has("event1"));
        JSONObject jsonParams = obj.getJSONObject("event1");
        Assert.assertNotNull("Params not found in json " + json, jsonParams);
        Assert.assertEquals("val1", jsonParams.getString("param1"));
        Assert.assertEquals("val2", jsonParams.getString("param2"));
    }
}
