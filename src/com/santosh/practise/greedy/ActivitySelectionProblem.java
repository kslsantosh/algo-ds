package com.santosh.practise.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
 */

public class ActivitySelectionProblem {
    public static void main(String[] args) {
        int[] startTimes = new int[]{8, 3, 0, 5, 5, 1};
        int[] endTimes = new int[]{9, 4, 6, 7, 9, 2};

        maximizeNumberOfMeetingsCanAttend(startTimes, endTimes);
    }

    private static void maximizeNumberOfMeetingsCanAttend(int[] startTimes, int[] endTimes) {
        // First sort the above arrays by end times
        List<Timings> timings = new ArrayList<>();
        for(int i = 0; i < startTimes.length; i++) {
            timings.add(new Timings(startTimes[i], endTimes[i]));
        }
        Comparator<Timings> endTimeComparator = (Timings o1, Timings o2) -> o1.endTime - o2.endTime;
        timings.sort(endTimeComparator);

        int previousEndTime = 0;
        for(Timings timing : timings) {
            if(timing.startTime >= previousEndTime) {
                System.out.println("Choosing activity with " + timing.toString());
                previousEndTime = timing.endTime;
            }
        }
    }
}

class Timings {
    int startTime;
    int endTime;

    Timings(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Start: " + this.startTime + " End: " + this.endTime;
    }
}
