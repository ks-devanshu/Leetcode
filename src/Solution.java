import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
// Better Approach
//        int[] counts = new int[2];
//        for (int student : students) counts[student]++;
//
//        int remaining = sandwiches.length;
//        for (int sandwich : sandwiches) {
//            if (counts[sandwich] == 0) break;
//            if (remaining-- == 0) break;
//            counts[sandwich]--;
//        }
//
//        return remaining;

        int n = students.length;
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> repeat = new ArrayDeque<>();
        for (var student : students)
            queue.add(student);
        int top = 0;
        int repeatSize = 0;

        while (top < n && repeatSize != queue.size()) {
            while (!queue.isEmpty()) {
                var choice = queue.remove();
                if (choice == sandwiches[top])
                    top++;
                else
                    repeat.add(choice);
            }
            repeatSize = repeat.size();
            while (!repeat.isEmpty()) {
                var choice = repeat.remove();
                if (choice == sandwiches[top])
                    top++;
                else
                    queue.add(choice);
            }
        }

        return queue.size() == 0 ? repeat.size() : queue.size();

    }
}