package com.santosh.practise.arrays;

/**
 * LeetCode 134
 */
public class CircularGasStations {
    public static void main(String[] args) {
//        int[] gas = new int[]{1,2,3,4,5};
//        int[] cost = new int[]{3,4,5,1,2};

//        int[] gas = new int[]{2,3,4};
//        int[] cost = new int[]{3,4,3};
//        int[] gas = new int[]{3};
//        int[] cost = new int[]{1};

//        int[] gas = new int[]{3, 3, 4};
//        int[] cost = new int[]{3, 4, 4};
//        int[] gas = new int[] {5,0,9,4,3,3,9,9,1,2};
//        int[] cost = new int[]{6,7,5,9,5,8,7,1,10,5};

        int[] gas = new int[] {5,1,2,3,4};
        int[] cost = new int[] {4,4,1,5,1};

        int gasStationToStart = findGasStationToStart(gas, cost);
        System.out.println("Starting point " + gasStationToStart);

    }

    private static int findGasStationToStart(int[] gas, int[] cost) {
        int start = -1;
        int gasAvailable = 0;
        int length = gas.length;

        for(int i = 0; i < gas.length; i++) {
            if(gas[i] >= cost[i]) {
                start = i;
                gasAvailable = gas[i] - cost[i];
                break;
            }
        }
        if(start == -1) {
            // it means that no gas station found with which has more fuel to travel to its next station
            return -1;
        }
        int current = (start + 1) % gas.length;
//        if(start == gas.length-1) {
//            current = 0;
//        } else {
//            current = start+1;
//        }
        System.out.println("Startng with " + start);
        System.out.println("Current with " + current);
        System.out.println("Startng with gas " + gasAvailable);
        int firstStartingPoint = start;
        while (start != current) {
            System.out.println("Start: " + start);
            System.out.println("Current: " + current);

            gasAvailable = gasAvailable +  (gas[current] - cost[current]);
            System.out.println("gas available" + gasAvailable);

            if(gasAvailable < 0) {
                // we reached a point where we cannot travel to the next gas station, so we need to shift our starting point to the next station where gas available > next station distance
                // if we are just behind the start, then we cannot travel
                //if(current == start-1) return -1;

                // loop start from current
                current = (current+1) % length;
                while(gas[current] - cost[current] < 0 && current != start && current != firstStartingPoint) {
                    current = (current+1) % length;
                    System.out.println("Current became:" + current);
                }
                if(current == firstStartingPoint) return -1;

                System.out.println("Shifting start next Point::" + current);
                start = current;
                current = (start+1) % length;
                System.out.println("Shifting current next Point::" + current);
                if(current == firstStartingPoint) return -1;
                gasAvailable = gas[start] - cost[start];
            }
            else {
                // no problem, continue to the next station
                current = ( current + 1 ) % length;
            }
        }
        System.out.println("start::" + start);
        System.out.println("gas available after trip::" + gasAvailable);
        if(gasAvailable >= 0) {
            return start;
        } else {
            return -1;
        }
    }
}