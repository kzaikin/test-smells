/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package reliability.random;

import java.util.ArrayList;
import java.util.List;

class Generator {
    static List<Integer> getFixedSizeCollection(double size) {
        List<Integer> entries = new ArrayList<>();
        for (int j = 0; j < size; j++) {
            entries.add(j);
        }
        return entries;
    }
}
