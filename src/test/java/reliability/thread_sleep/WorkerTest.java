/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package reliability.thread_sleep;

import org.junit.Test;
import sample.Bad;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class WorkerTest {
    static final long INTERVAL = 1000;

    Worker worker = new Worker();

    @Bad("Test is waiting for real 1000ms")
    @Test public void itIsTime_afterAWhile() throws InterruptedException {
        worker.markCurrentTime();
        Thread.sleep(INTERVAL);
        assertThat(worker.itIsTime(), is(true));
    }

    class Worker {
        private long start;

        void markCurrentTime() {
            start = System.currentTimeMillis();
        }

        boolean itIsTime() {
            return (System.currentTimeMillis() - start) > 500;
        }
    }
}
