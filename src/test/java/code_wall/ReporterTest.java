package code_wall;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import sample.Good;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class ReporterTest {

    static final String GROUP = "group1";
    static final String EVENT = "event1";

    @Mock Adapter adapter;

    private Reporter reporter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        reporter = new Reporter(adapter);
    }

    @Good
    @Test public void logGroupedEvent_createsValidJson() {
        reporter.logGrouppedEvent(GROUP, EVENT, getEventParams());

        verify(adapter).reportEvent(eq(GROUP), argThat(validJson()));
    }

    @Nonnull
    ArgumentMatcher<String> validJson() {
        return json -> {
            try {
                JSONObject obj = new JSONObject(json);
                JSONObject jsonParams = obj.getJSONObject(EVENT);
                return "val1".equals(jsonParams.getString("param1"))
                        && "val2".equals(jsonParams.getString("param2"));
            } catch (JSONException e) {
                return false;
            }
        };
    }

    @Nonnull
    Map<String, String> getEventParams() {
        Map<String, String> params = new HashMap<>();
        params.put("param1", "val1");
        params.put("param2", "val2");
        return params;
    }
}
