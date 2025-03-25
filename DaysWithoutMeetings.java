import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Link to the assignment: https://leetcode.com/problems/count-days-without-meetings/

public class DaysWithoutMeetings {

    // Helper class to store meeting intervals. Start = start day, end = end day of the interval
    static class Interval {
        int start;
        int end;
        
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int countDays(int days, int[][] meetings) {
        // List to store intervals of meetings
        List<Interval> intervals = new ArrayList<>();

        // Convert each meeting into an interval and add to the list of intervals
        for (int[] meeting : meetings) {
            intervals.add(new Interval(meeting[0], meeting[1]));
        }

        // Sort intervals by start day
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        // Merge overlapping intervals
        List<Interval> mergedIntervals = new ArrayList<>();
        
        for (Interval interval : intervals) {
            if (mergedIntervals.isEmpty() || mergedIntervals.get(mergedIntervals.size() - 1).end < interval.start) {
                mergedIntervals.add(interval);
            } else {
                // There is overlap, so we merge the intervals
                mergedIntervals.get(mergedIntervals.size() - 1).end = Math.max(mergedIntervals.get(mergedIntervals.size() - 1).end, interval.end);
            }
        }

        // Calculate the total number of unavailable days by summing up the lengths of the merged intervals
        int unavailableDays = 0;
        for (Interval interval : mergedIntervals) {
            unavailableDays += interval.end - interval.start + 1; // inclusive
        }

        // The remaining days are the total days minus the unavailable days
        return days - unavailableDays;
    }

    // Testing the snippet
    public static void main(String[] args) {
        DaysWithoutMeetings daysWithoutMeetings = new DaysWithoutMeetings();  
        // Testing using the given days and meeting intervals
        int[][] meetings = {{5, 7}, {1, 3}, {9, 10}}; 
        int result = daysWithoutMeetings.countDays(10, meetings); 
        // Output the result
        System.out.println("Remaining days: " + result); 
    }
}
