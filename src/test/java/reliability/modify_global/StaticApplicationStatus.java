/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package reliability.modify_global;

class StaticApplicationStatus {
    static boolean isFirstStart = false;

    boolean isFirstStart() {
        return isFirstStart;
    }
}
