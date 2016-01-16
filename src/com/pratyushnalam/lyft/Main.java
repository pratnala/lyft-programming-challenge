package com.pratyushnalam.lyft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    double haversine(double angle) {
        return Math.pow(Math.sin(angle / 2), 2);
    }

    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] a,
                b,
                c,
                d;
        double a1, a2,
                b1, b2,
                c1, c2,
                d1, d2;
        try {
            System.out.println("Enter coordinates of A as lat, long");
            a = input.readLine().split(" ");
            a1 = Double.parseDouble(a[0]);
            a2 = Double.parseDouble(a[1]);
            System.out.println("Enter coordinates of B as lat, long");
            b = input.readLine().split(" ");
            b1 = Double.parseDouble(b[0]);
            b2 = Double.parseDouble(b[1]);
            System.out.println("Enter coordinates of C as lat, long");
            c = input.readLine().split(" ");
            c1 = Double.parseDouble(c[0]);
            c2 = Double.parseDouble(c[1]);
            System.out.println("Enter coordinates of D as lat, long");
            d = input.readLine().split(" ");
            d1 = Double.parseDouble(d[0]);
            d2 = Double.parseDouble(d[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
