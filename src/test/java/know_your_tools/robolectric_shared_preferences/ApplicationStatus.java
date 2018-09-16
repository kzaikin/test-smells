/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package know_your_tools.robolectric_shared_preferences;

import android.content.Context;
import android.content.SharedPreferences;

class ApplicationStatus {
    static final String STATUS_PREFERENCES = "status";
    static final String FIRST_START = "first_start";

    private Context context;

    ApplicationStatus(Context context) {
        this.context = context;
    }

    boolean isFirstStart() {
        SharedPreferences preferences = context.getSharedPreferences(STATUS_PREFERENCES, Context.MODE_PRIVATE);
        return preferences.getBoolean(FIRST_START, false);
    }
}
