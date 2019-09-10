package com.santosh.practise.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaxPlatformsRequired {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter No of trains");
        int trainsCount = s.nextInt();
        System.out.println("Enter arrival times: ");
        int[] arrivals = new int[trainsCount];
        int[] departures = new int[trainsCount];

        for(int i = 0; i < trainsCount; i++) {
            arrivals[i] = s.nextInt();
        }
        System.out.println("Enter departure times: ");
        for(int i = 0; i < trainsCount; i++) {
            departures[i] = s.nextInt();
        }
        int minimumPlatformsRequired = getMinimumPlatformsRequired(arrivals, departures, trainsCount);
        System.out.println("Minimum Platforms Required = " + minimumPlatformsRequired);
    }

    private static int getMinimumPlatformsRequired(int[] arrivals, int[] departures, int trainsCount) {
        Arrays.sort(arrivals);
        Arrays.sort(departures);
        int maxPlatfromTillNow = 0;
        int minimumPlatformsRequired = 0;

        int i = 0;
        int j = 0;
        while (i < trainsCount && j < trainsCount) {
            if(arrivals[i] < departures[j]) {
                i++;
                minimumPlatformsRequired++;
                if(minimumPlatformsRequired > maxPlatfromTillNow) maxPlatfromTillNow = minimumPlatformsRequired;
            } else if(departures[j] < arrivals[i]) {
                j++;
                minimumPlatformsRequired--;
            }
        }
        return maxPlatfromTillNow;
    }
}
