package com.minhnln.MaxPointsOnLine.solution;

import com.minhnln.MaxPointsOnLine.utils.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {
    private static final Object[] getDataInputForTestingCalculateSlopeParameter() {
        return new Object[] {
                new Object[] {new Point(1, 2), new Point(5, 7), new Line( new Fraction(5, 4), new Fraction(3, 4))},
                new Object[] {new Point(1, 65536), new Point(0, 0), new Line(new Fraction(65536, 1), new Fraction(0, 1))},
                new Object[] {new Point(65536, 2), new Point(5, 65536), new Line(new Fraction(-65534, 65531), new Fraction(4294967286L, 65531))},
        };
    }

    @Test
    @Parameters(method = "getDataInputForTestingCalculateSlopeParameter")
    public void shouldCalculateSlopeParameterCorrectly(Point p1, Point p2, Line line) {
        Line paramReturn = Solution.calculateLineParameter(p1, p2);

        boolean temp = line.equals(paramReturn);

        assertTrue("The line connect between " + p1.toString() + " and " + p2.toString() + " should be "
                + line.toString() + " while the return value is " + paramReturn.toString(),
                line.equals(paramReturn));
    }

    private static final Object[] getDataInputForTestingFindMaxPointsOnLineMethod() {
        return new Object[] {
//                new Object[] { null, 0},
//                new Object[] { new Point[] {new Point(0,0)}, 1},
                new Object[] { new Point[] {new Point(0,0), new Point(0,0)}, 2}
//                new Object[] { new Point[] {new Point(0,0), new Point(1,1), new Point(1,-1)}, 2},
//                new Object[] { new Point[] {
//                        new Point(0,-12),
//                        new Point(5,2),
//                        new Point(2,5),
//                        new Point(0,-5),
//                        new Point(1,5),
//                        new Point(2,-2),
//                        new Point(5,-4),
//                        new Point(3,4),
//                        new Point(-2,4),
//                        new Point(-1,4),
//                        new Point(0,-5),
//                        new Point(0,-8),
//                        new Point(-2,-1),
//                        new Point(0,-11),
//                        new Point(0,-9)}, 6
//                }
        };
    }

    @Test
    @Parameters(method = "getDataInputForTestingFindMaxPointsOnLineMethod")
    public void shouldFindMaxPointsOnLineCorrectly(Point[] points, int result) {
        int returnValue = Solution.maxPoints(points);
        assertEquals(result, returnValue);
    }
}
