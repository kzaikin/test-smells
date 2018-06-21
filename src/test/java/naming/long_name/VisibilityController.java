/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package naming.long_name;

class VisibilityController {
    private Listener listener;
    private boolean enabled;
    private int visibility;

    void setEnabled(boolean v) {
        this.enabled = v;
    }

    void notifyVisibilityChange(int v) {
        if (visibility == v) {
            return;
        }
        this.visibility = v;
        if (enabled) {
            listener.onVisibilityChange(v);
        }
    }

    void setListener(Listener l) {
        listener = l;
    }

    class Listener {
        void onVisibilityChange(int visibility) {
        }
    }
}
