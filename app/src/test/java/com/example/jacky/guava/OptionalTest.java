package com.example.jacky.guava;

import com.Utils;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Optional;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Test;

import java.util.Set;


@GwtCompatible(emulated = true)
public class OptionalTest extends TestCase {

    @GwtIncompatible // suite
    public static junit.framework.Test suite() {
        TestSuite suite = new TestSuite(OptionalTest.class.getSimpleName());
        suite.addTestSuite(OptionalTest.class);
        return suite;
    }

    @Test
    public void option_test() {
        final Optional<Integer> optional = Optional.of(5);
        if (optional.isPresent()) {
            Utils.println(optional.get());
        }

        Utils.println(Optional.absent().isPresent());
    }

    @Test
    public void or_test() {
        //        Utils.println(Optional.fromNullable(null).get());          fail

        Utils.println(Optional.of(5).orNull());
        Utils.println(Optional.fromNullable(null).orNull());
        Utils.println(Optional.absent().or(5));

    }

    @Test
    public void asset_test() {
        final Set<Integer> integers = Optional.of(5).asSet();       //Returns an immutable singleton Set containing the instance in this Optional
        Utils.println(integers);

        final Set<Object> collections = Optional.absent().asSet();      //empty list
        Utils.println(collections);
    }
}
