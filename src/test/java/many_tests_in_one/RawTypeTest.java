/*
 * Copyright (C) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package many_tests_in_one;

import com.google.common.reflect.TypeToken;
import org.junit.Test;
import sample.Bad;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import static many_tests_in_one.Utils.getRawType;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * This file is a copy of https://github.com/square/retrofit/blob/master/retrofit/src/test/java/retrofit2/CallAdapterTest.java
 * for test smell demo.
 */
public class RawTypeTest {
    @Bad
    @Test public void rawTypes() throws NoSuchMethodException {
        assertThat(getRawType(String.class), equalTo(String.class));

        Type listOfString = new TypeToken<List<String>>() {
        }.getType();
        assertThat(getRawType(listOfString), equalTo(List.class));

        Type stringArray = new TypeToken<String[]>() {
        }.getType();
        assertThat(getRawType(stringArray), equalTo(String[].class));

        Type wild = ((ParameterizedType) new TypeToken<List<? extends CharSequence>>() {
        }.getType()).getActualTypeArguments()[0];
        assertThat(getRawType(wild), equalTo(CharSequence.class));

        Type wildParam = ((ParameterizedType) new TypeToken<List<? extends List<String>>>() {
        }.getType()).getActualTypeArguments()[0];
        assertThat(getRawType(wildParam), equalTo(List.class));

        Type typeVar = A.class.getDeclaredMethod("method").getGenericReturnType();
        assertThat(getRawType(typeVar), equalTo(Object.class));
    }
}
