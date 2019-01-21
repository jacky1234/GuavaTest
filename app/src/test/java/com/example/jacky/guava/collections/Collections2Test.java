package com.example.jacky.guava.collections;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.testing.CollectionTestSuiteBuilder;
import com.google.common.collect.testing.TestStringCollectionGenerator;
import com.google.common.collect.testing.features.CollectionFeature;
import com.google.common.collect.testing.features.CollectionSize;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@GwtCompatible(emulated = true)
public class Collections2Test extends TestCase {

    @GwtIncompatible // suite
    public static Test suite() {
        TestSuite suite = new TestSuite(Collections2Test.class.getSimpleName());
        suite.addTest(testsForFilter());
        suite.addTestSuite(Collections2Test.class);
        return suite;
    }

    static final Predicate<String> NOT_YYY_ZZZ =
            new Predicate<String>() {
                @Override
                public boolean apply(String input) {
                    return !"yyy".equals(input) && !"zzz".equals(input);
                }
            };

    static final Predicate<String> LENGTH_1 =
            new Predicate<String>() {
                @Override
                public boolean apply(String input) {
                    return input.length() == 1;
                }
            };

    static final Predicate<String> STARTS_WITH_VOWEL =
            new Predicate<String>() {
                @Override
                public boolean apply(String input) {
                    return Arrays.asList('a', 'e', 'i', 'o', 'u').contains(input.charAt(0));
                }
            };

    @GwtIncompatible // suite
    private static Test testsForFilter() {
        return CollectionTestSuiteBuilder.using(
                new TestStringCollectionGenerator() {
                    @Override
                    public Collection<String> create(String[] elements) {
                        List<String> unfiltered = Lists.newArrayList();
                        unfiltered.add("yyy");
                        Collections.addAll(unfiltered, elements);
                        unfiltered.add("zzz");
                        return Collections2.filter(unfiltered, NOT_YYY_ZZZ);
                    }
                })
                .named("Collections2.filter")
                .withFeatures(
                        CollectionFeature.SUPPORTS_ADD,
                        CollectionFeature.SUPPORTS_REMOVE,
                        CollectionFeature.ALLOWS_NULL_VALUES,
                        CollectionFeature.KNOWN_ORDER,
                        CollectionSize.ANY)
                .createTestSuite();
    }
}
