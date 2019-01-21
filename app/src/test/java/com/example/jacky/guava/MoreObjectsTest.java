package com.example.jacky.guava;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Assert;
import org.junit.Test;

@GwtCompatible(emulated = true)
public class MoreObjectsTest extends TestCase {
    @GwtIncompatible // suite
    public static junit.framework.Test suite() {
        TestSuite suite = new TestSuite(MoreObjectsTest.class.getSimpleName());
        suite.addTestSuite(MoreObjectsTest.class);
        return suite;
    }


    @Test
    public void testForCommon() {
        //if both of the inputs are null, it fails fast with a NullPointerException
        Assert.assertSame(MoreObjects.firstNonNull(Optional.<Integer>absent().or(5), null), 5);
    }
}
