import java.util.PriorityQueue;

public class queues {
    public static class student implements Comparable<student> {
        String name;
        int rank;

        student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<student> q = new PriorityQueue<>();
        q.add(new student("saikat", 4));
        q.add(new student("mandal", 46));
        q.add(new student("kaveri", 100));
        q.add(new student("shardul", 6));

        while (!q.isEmpty()) {
            System.out.println(q.peek().name + "->" + q.peek().rank);
            q.remove();
        }
    }
}