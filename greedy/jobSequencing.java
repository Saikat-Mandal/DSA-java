import java.util.ArrayList;
import java.util.Collections;

public class jobSequencing {
    static class Job {
        int deadline;
        int profit;
        int id;

        Job(int id, int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
            this.id = id;
        }
    }

    public static void main(String[] args) {
        int[][] jobInfo = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        ArrayList<Job> job = new ArrayList<>();
        for (int i = 0; i < jobInfo.length; i++) {
            job.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        Collections.sort(job, (a, b) -> b.profit - a.profit); // decending order profit sort

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < job.size(); i++) {
            Job cur = job.get(i);
            if (cur.deadline > time) {
                seq.add(cur.id);
                time++;
            }
        }

        System.out.println(seq);
    }
}
