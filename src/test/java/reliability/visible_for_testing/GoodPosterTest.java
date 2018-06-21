/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package reliability.visible_for_testing;

import android.os.Handler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import sample.Good;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class GoodPosterTest {

    static final String MESSAGE = "test";

    @Mock Logger logger;

    @Before public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Good("Only public class interface is used")
    @Test public void postMessage_logs() {
        Poster poster = new Poster(logger);
        poster.postMessage(MESSAGE);
        Robolectric.flushForegroundThreadScheduler();
        verify(logger).log(anyString(), eq(MESSAGE));
    }

    public static class Poster {
        final Handler handler;
        final Logger logger;

        public Poster(Logger l) {
            logger = l;
            handler = new Handler();
        }

        void postMessage(String message) {
            handler.post(() -> logger.log("Poster", message));
        }
    }

}