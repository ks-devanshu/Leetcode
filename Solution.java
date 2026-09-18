class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length(), m = t.length();
        if (n != m)
            return false;
        
        Map<Character, Integer> map = new HashMap<>();

        for (var alpha : s.toCharArray()) {
            if (map.containsKey(alpha))
                map.replace(alpha, map.get(alpha)+1);
            else
                map.put(alpha, 1);
        }
        for (var alpha : t.toCharArray()) {
            if (map.containsKey(alpha) && map.get(alpha) > 0)
                map.replace(alpha, map.get(alpha)-1);
            else
                return false;
        }

        return true;

    }
}