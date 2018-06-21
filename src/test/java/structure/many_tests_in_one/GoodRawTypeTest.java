/*
 * Copyright (c) 2018 Test Smells Project. All rights reserved.
 * Author: Kosta Zaikin <zaikin@list.ru>
 */

package structure.many_tests_in_one;

import com.google.common.reflect.TypeToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import sample.Good;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static structure.many_tests_in_one.Utils.getRawType;

/**
 * This file is a refactoring of https://github.com/square/retrofit/blob/master/retrofit/src/test/java/retrofit2/CallAdapterTest.java
 * for test smell demo.
 */
@RunWith(Parameterized.class)
public class GoodRawTypeTest {
    @Parameters(name = "getRawType({0}) is {1}")
    public static Object[][] parameters() throws NoSuchMethodException {
        return new Object[][]{
                {String.class,
                        String.class},
                {new TypeToken<List<String>>() {}.getType(),
                        List.class},
                {new TypeToken<String[]>() {}.getType(),
                        String[].class},
                {((ParameterizedType) new TypeToken<List<? extends CharSequence>>() {}.getType()).getActualTypeArguments()[0],
                        CharSequence.class},
                {((ParameterizedType) new TypeToken<List<? extends List<String>>>() {}.getType()).getActualTypeArguments()[0],
                        List.class},
                {A.class.getDeclaredMethod("method").getGenericReturnType(),
                        Object.class}};
    }

    @Parameter(value = 0) public Type sourceType;

    @Parameter(value = 1) public Class<?> rawType;

    @Good("Test is short. Test run results display each check separately.")
    @Test public void rawTypes() {
        assertThat(getRawType(sourceType), equalTo(rawType));
    }
}
