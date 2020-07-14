package com.jstu.serve;

import ch.hsr.geohash.GeoHash;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.000000");
        GeoHash geoHash1 = GeoHash.fromGeohashString("wtsq");
        String latitude = df.format(geoHash1.getPoint().getLatitude());
        String longitude = df.format(geoHash1.getPoint().getLongitude());
        System.out.println(latitude + " " + " " + longitude);

        System.out.println(System.currentTimeMillis());
    }
}
