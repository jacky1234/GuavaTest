package com.google.common.collect;

import com.Utils;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Predicate;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static com.google.common.collect.Lists.newArrayList;

@GwtCompatible(emulated = true)
public class Collections2Test extends TestCase {

    @GwtIncompatible // suite
    public static junit.framework.Test suite() {
        TestSuite suite = new TestSuite(Collections2Test.class.getSimpleName());
        suite.addTestSuite(Collections2Test.class);
        return suite;
    }

    private final List<String> data = newArrayList("d", "a", "z", "c");

    @Test
    public void testForFilter() {
        final Collection<String> filter = Collections2.filter(data, new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return !"a".equals(input);
            }
        });
        Utils.println(filter);
    }

    @Test
    public void testOrderedPermutationSetRepeatedElements() {
        List<Integer> list = newArrayList(1, 1, 2, 2);
        Iterator<List<Integer>> permutations =
                Collections2.orderedPermutations(list, Ordering.natural()).iterator();
        assertNextPermutation(newArrayList(1, 1, 2, 2), permutations);
        assertNextPermutation(newArrayList(1, 2, 1, 2), permutations);
        assertNextPermutation(newArrayList(1, 2, 2, 1), permutations);
        assertNextPermutation(newArrayList(2, 1, 1, 2), permutations);
        assertNextPermutation(newArrayList(2, 1, 2, 1), permutations);
        assertNextPermutation(newArrayList(2, 2, 1, 1), permutations);
        assertNoMorePermutations(permutations);
    }

    private <T> void assertNextPermutation(
            List<T> expectedPermutation, Iterator<List<T>> permutations) {
        assertTrue("Expected another permutation, but there was none.", permutations.hasNext());
        assertEquals(expectedPermutation, permutations.next());
    }

    private <T> void assertNoMorePermutations(Iterator<List<T>> permutations) {
        assertFalse("Expected no more permutations, but there was one.", permutations.hasNext());
        try {
            permutations.next();
            fail("Expected NoSuchElementException.");
        } catch (NoSuchElementException expected) {
        }
    }

}
