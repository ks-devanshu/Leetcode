import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        for (var each : s.toCharArray()) {
            if (stack.isEmpty()) {
                if (each == ')' || each == '}' || each == ']')
                    return false;
                stack.push(each);
            }
            else {
                if (each == map.get(stack.peek()))
                    stack.pop();
                else if (map.containsKey(each))
                    stack.push(each);
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}