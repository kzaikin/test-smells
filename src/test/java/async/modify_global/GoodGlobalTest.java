/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package async.modify_global;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import sample.Good;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GoodGlobalTest {
    static final long INTERVAL = 1000;

    @Mock TimeProvider provider;
    @InjectMocks Worker worker;

    @Good("Time is controlled with custom time provider. " +
            "Test is fast and reliable")
    @Test public void timeIsGood_afterTime() {
        worker.markCurrentTime();
        when(provider.currentTimeMillis()).thenReturn(INTERVAL);
        assertThat(worker.itIsTime(), is(true));
    }

    static class Worker {
        private final TimeProvider provider;
        private long start;

        public Worker(TimeProvider p) {
            provider = p;
        }

        void markCurrentTime() {
            start = provider.currentTimeMillis();
        }

        boolean itIsTime() {
            return (provider.currentTimeMillis() - start) > 500;
        }
    }

    static class TimeProvider {
        long currentTimeMillis() {
            return 0;
        }
    }
}
