package com.minhnln.MaxPointsOnLine.utils;

public class Fraction {
    private long num;
    private long den;

    public Fraction(long num, long den) {
        this.num = num;
        this.den = den;
    }

    public static long gcd(long a, long b) {
        if (a == 0) return b;
        if (b == 0) return a;

        long temp;

        if (a >= b) {
            temp = a / b;
            return gcd(a - b*temp, b);
        }
        else {
            temp = b / a;
            return gcd(a, b - a*temp);
        }
    }

    public Fraction minimal() {
        long scale = gcd(Math.abs(num), Math.abs(den));

        num = num / scale;
        den = den / scale;

        if (den < 0) {
            num = - num;
            den = - den;
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (null == o) return false;
        if (this == o) return true;
        if (!(o instanceof Fraction)) return false;

        Fraction f = (Fraction) o;
        this.minimal();
        f.minimal();
        if ((this.num == f.num) && (this.den == f.den))
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return (int)((num << 16) + den);
    }

    @Override
    public String toString() {
        return num + " \\ " + den;
    }
}
