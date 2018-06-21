/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package naming.long_name;

import android.view.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import sample.Bad;
import sample.Good;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class VisibilityControllerTest {
    VisibilityController visibilityController;

    @Mock VisibilityController.Listener listener;

    @Before
    public void setUp() {
        visibilityController = new VisibilityController();
        visibilityController.setListener(listener);
    }

    @Bad("Name is too long to fit the screen")
    @Test public void notifyVisibilityWhenDisabledAssertOnVisibilityChangedAnyIntCallsOnlyOnce() {
        visibilityController.setEnabled(true);
        visibilityController.notifyVisibilityChange(View.INVISIBLE);
        visibilityController.notifyVisibilityChange(View.INVISIBLE);
        verify(listener).onVisibilityChange(View.INVISIBLE);
    }

    @Good("Name is short and sound")
    @Test public void singleChangeNotification_whenEnabled() {
        visibilityController.setEnabled(true);
        visibilityController.notifyVisibilityChange(View.INVISIBLE);
        visibilityController.notifyVisibilityChange(View.INVISIBLE);
        verify(listener).onVisibilityChange(View.INVISIBLE);
    }
}
