package utils;

import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;

public class SystemOutMatcher extends TypeSafeMatcher<ByteArrayOutputStream> {
    private String reference;

    public static Matcher<ByteArrayOutputStream> has(String string) {
        return new SystemOutMatcher(string);
    }

    private SystemOutMatcher(String string) {
        reference = string;
    }

    @Override
    protected boolean matchesSafely(ByteArrayOutputStream item) {
        try {
            BufferedReader reader = new BufferedReader(new StringReader(item.toString()));
            return reference.equals(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void describeTo(org.hamcrest.Description description) {
    }
}
