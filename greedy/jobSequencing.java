import java.util.ArrayList;
import java.util.Collections;

public class jobSequencing {
    static class Job {
        int deadline, profit, id;

        Job(int deadline, int profit, int id) {
            this.deadline = deadline;
            this.profit = profit;
            this.id = id;
        }
    }

    public static void main(String[] args) {
        int jobsInfo[][] = { { 4, 20 }, { 1, 20 }, { 1, 40 }, { 1, 30 } };

        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(jobsInfo[i][0], jobsInfo[i][1], i));
        }

        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        ArrayList<Integer> res = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < jobs.size(); i++) {
            if (time < jobs.get(i).deadline) {
                time++;
                res.add(jobs.get(i).id);
            }
        }
        System.out.println(res);
    }
}
