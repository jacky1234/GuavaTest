package com.example.jacky.guava;

import com.Utils;
import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;

import org.junit.Test;

public class MoreObjectsTest {
    @Test
    public void moreObject_test() {
        //if both of the inputs are null, it fails fast with a NullPointerException
        final Integer result = MoreObjects.firstNonNull(Optional.<Integer>absent().or(5), null);
        Utils.println(result);
    }
}
