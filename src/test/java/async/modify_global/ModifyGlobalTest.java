/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package async.modify_global;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import sample.Bad;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

import static org.hamcrest.Matchers.is;

@RunWith(RobolectricTestRunner.class)
public class ModifyGlobalTest {
    @Test
    @Bad("Global system settings are modified and are never set to original values. " +
            "Async code is tested asynchronously")
    public synchronized void foo() {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) AsyncTask.THREAD_POOL_EXECUTOR;
        executor.setCorePoolSize(1);
        executor.setMaximumPoolSize(1);

//        SharedPreferences.edit().putBoolean(IS_FIRST_START).commit();

        AsyncTask<Double, Void, Double> asyncTask = new AsyncTask<Double, Void, Double>() {
            @Override
            protected Double doInBackground(Double... doubles) {
                // some lengthy operation
                return Math.sin(doubles[0]);
            }

            @Override
            protected void onPostExecute(Double aDouble) {
                notifyWaiter();
            }
        };
        asyncTask.execute(Math.PI);

        try {
            this.wait();
            Assert.assertThat(asyncTask.get(), is(0));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private synchronized void notifyWaiter() {
        notifyAll();
    }
}
