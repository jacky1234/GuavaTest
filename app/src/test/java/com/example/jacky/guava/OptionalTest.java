package com.example.jacky.guava;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Optional;
import com.google.common.testing.NullPointerTester;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;


@GwtCompatible(emulated = true)
public class OptionalTest extends TestCase {
    @GwtIncompatible // suite
    public static junit.framework.Test suite() {
        TestSuite suite = new TestSuite(OptionalTest.class.getSimpleName());
        suite.addTestSuite(OptionalTest.class);
        return suite;
    }

    @Test
    public void testForCommonOption() {
        Assert.assertSame(Optional.of(5).get(), 5);
        Assert.assertSame(Optional.of(5).orNull(), 5);
        Assert.assertSame(Optional.absent().or(5), 5);
        Assert.assertSame(Optional.fromNullable(null).orNull(), null);
        Assert.assertFalse(Optional.absent().isPresent());

        Assert.assertArrayEquals(Optional.of(5).asSet().toArray(), new Integer[]{5});
        Assert.assertSame(Optional.absent().asSet(), Collections.emptySet());
    }

}
