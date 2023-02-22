import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class activitySelection {

    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };
        int[][] activities = new int[end.length][3];
        // sorting
        for (int i = 0; i < activities.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        // lambda function to sort on the basis of column
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // end time basis sort
        int count = 0;
        ArrayList<Integer> l = new ArrayList<>();

        // 1st activity
        count = 1;
        l.add(activities[0][0]);

        int lastEnd = activities[0][2];
        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastEnd) {
                // activity select
                count++;
                l.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("max activity: " + count);

        System.out.println(l);

    }
}