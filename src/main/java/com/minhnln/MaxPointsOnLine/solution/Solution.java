package com.minhnln.MaxPointsOnLine.solution;

import com.minhnln.MaxPointsOnLine.utils.Fraction;
import com.minhnln.MaxPointsOnLine.utils.Line;
import com.minhnln.MaxPointsOnLine.utils.Point;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    private static HashMap<Line, HashSet<Point>> map = new HashMap<>();

    public static Line calculateLineParameter(Point p1, Point p2) {
        int num = p2.getY() - p1.getY();
        int den = p2.getX() - p1.getX();

        Fraction a;
        Fraction b;

        if (num == 0) {
            a = new Fraction(0, 1);
            b = new Fraction(p1.getY(), 1);
        }
        else if (den == 0) {
            a = new Fraction(1, 0);
            b = new Fraction(p1.getX(), 1);
        }
        else {
            a = new Fraction(num, den);
            b = new Fraction((long)p1.getY()*(long)den - (long)p1.getX()*(long)num, den);
        }

        return new Line(a.minimal(), b.minimal());
    }

    public static int maxPoints(Point[] points) {
        Line slope;

        if (null == points)
            return 0;

        if (points.length < 2) {
            return points.length;
        }

        for (Point p1 : points) {
            for (Point p2 : points) {
                if (p2 == p1) continue;

                slope = calculateLineParameter(p1, p2);

                if (!map.containsKey(slope)) {
                    map.put(slope, new HashSet<>());
                }
                map.get(slope).add(p1);
                map.get(slope).add(p2);
            }
        }

        int maxPoint = 0;

        for (HashSet hashSet : map.values()) {
            if (maxPoint < hashSet.size()) maxPoint = hashSet.size();
        }

        return maxPoint;
    }
}
