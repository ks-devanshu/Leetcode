import java.util.Stack;
public class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> scores = new Stack<>();
        for (var op : operations) {
            if (op.equals("C"))
                scores.pop();
            else if (op.equals("D")) {
                scores.push(scores.peek()*2);
            }
            else if (op.equals("+")) {
                int top = scores.pop();
                int newScore = top + scores.peek();
                scores.push(top);
                scores.push(newScore);
            }
            else
                scores.push(Integer.parseInt(op));
        }

        int sum = 0;
        while (!scores.isEmpty())
            sum += scores.pop();
        return sum;
    }
}