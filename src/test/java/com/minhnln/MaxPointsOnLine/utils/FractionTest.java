package com.minhnln.MaxPointsOnLine.utils;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


@RunWith(JUnitParamsRunner.class)
public class FractionTest {
    private static final Object[] getDataForTestingGcdAlgorithm() {
        return new Object[] {
                new Object[] {4, 7, 1},
                new Object[] {12, 8, 4}
        };
    }

    @Test
    @Parameters(method = "getDataForTestingGcdAlgorithm")
    public void shouldGcdAlgorithmCorrectly(int a, int b, int result) {
        assertEquals(result, Fraction.gcd(a, b));
    }

    private static final Object[] getDataForTestingMinimalMethod() {
        return new Object[] {
                new Object[] {6, 8, 3, 4},
                new Object[] {-4, 8, -1, 2},
                new Object[] {-28, -8, 7, 2},
                new Object[] {24, -16, -3, 2}
        };
    }

    @Test
    @Parameters(method = "getDataForTestingMinimalMethod")
    public void shouldMinimalCorrectly(int num, int den, int mNum, int mDen) {
        Fraction f = new Fraction(num, den);
        f.minimal();
        assertTrue(f.equals(new Fraction(mNum, mDen)));
    }
}
