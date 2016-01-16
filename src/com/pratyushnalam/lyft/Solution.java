package com.pratyushnalam.lyft;

import com.pratyushnalam.lyft.model.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static Point a;
    static Point b;
    static Point c;
    static Point d;

    private static Double haversine(Double angle) {
        return Math.pow(Math.sin(angle / 2), 2);
    }

    private static Double distance(Point origin, Point destination) {
        Double radius = 6371.0; // Earth's radius
        Double deltaLat = Math.toRadians(origin.getLatitude() - destination.getLatitude());
        Double deltaLong = Math.toRadians(origin.getLongitude() - destination.getLongitude());
        Double haverLat = haversine(deltaLat);
        Double haverLong = haversine(deltaLong);
        Double haverDist = haverLat + Math.cos(Math.toRadians(origin.getLatitude())) * Math.cos(Math.toRadians
                (destination.getLatitude())) * haverLong;
        return 2 * radius * Math.atan2(Math.sqrt(haverDist), Math.sqrt(1 - haverDist));
    }

    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] nextLine;
        Double detourDist1;
        Double detourDist2;
        try {
            System.out.println("Enter coordinates of A as lat, long");
            nextLine = input.readLine().split(",");
            a = new Point(Double.parseDouble(nextLine[0]), Double.parseDouble(nextLine[1]));
            System.out.println("Enter coordinates of B as lat, long");
            nextLine = input.readLine().split(",");
            b = new Point(Double.parseDouble(nextLine[0]), Double.parseDouble(nextLine[1]));
            System.out.println("Enter coordinates of C as lat, long");
            nextLine = input.readLine().split(",");
            c = new Point(Double.parseDouble(nextLine[0]), Double.parseDouble(nextLine[1]));
            System.out.println("Enter coordinates of D as lat, long");
            nextLine = input.readLine().split(",");
            d = new Point(Double.parseDouble(nextLine[0]), Double.parseDouble(nextLine[1]));
            // Calculate ACDB
            detourDist1 = distance(a, c) + distance(c, d) + distance(d, b);
            System.out.println("ACDB: " + detourDist1);
            // Calculate CABD
            detourDist2 = distance(c, a) + distance(a, b) + distance(b, d);
            System.out.println("CABD: " + detourDist2);
            if (detourDist1 < detourDist2) {
                System.out.println("ACDB is shorter");
            } else if (detourDist1 > detourDist2) {
                System.out.println("CABD is shorter");
            } else {
                System.out.println("Both paths are equal");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
