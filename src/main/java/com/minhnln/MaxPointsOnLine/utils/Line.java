package com.minhnln.MaxPointsOnLine.utils;

public class Line {
    private Fraction a;
    private Fraction b;

    public Line (Fraction a, Fraction b) {
        this.a = a;
        this.b = b;
    }

    public Fraction getA() {
        return a;
    }

    public Fraction getB() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        if (null == o) return false;
        if (this == o) return true;
        if (!(o instanceof Line)) return false;

        Line line = (Line)o;

        if ((line.getA().equals(this.getA()) && line.getB().equals(this.getB())))
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return a.hashCode() << 16 + b.hashCode();
    }

    @Override
    public String toString() {
        return "y = " + a + "*x + " + b;
    }
}
