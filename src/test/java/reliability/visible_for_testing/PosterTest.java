/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package reliability.visible_for_testing;

import android.os.Handler;
import com.android.internal.annotations.VisibleForTesting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import sample.Bad;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PosterTest {

    static final String MESSAGE = "test";

    @Mock Handler handler;
    @Mock Logger logger;

    @Bad("One has to implement additional constructor to inject custom Handler implementation")
    @Test public void postMessage_logs() {
        when(handler.post(any(Runnable.class))).thenAnswer(invocation -> {
            ((Runnable) invocation.getArgument(0)).run();
            return true;
        });
        Poster poster = new Poster(logger, handler);
        poster.postMessage(MESSAGE);
        verify(logger).log(anyString(), eq(MESSAGE));
    }

    public static class Poster {
        final Handler handler;
        final Logger logger;

        public Poster(Logger l) {
            this(l, new Handler());
        }

        @VisibleForTesting
        Poster(Logger l, Handler handler) {
            this.logger = l;
            this.handler = handler;
        }

        void postMessage(String message) {
            handler.post(() -> logger.log("Poster", message));
        }
    }

}