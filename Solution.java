class Solution {
    public int countSeniors(String[] details) {
        int count = 0;

        for (var each : details) {
            var t = each.split("M");
            if (t.length < 2)
                t = each.split("F");
            if (t.length < 2)
                t = each.split("O");
            String age = t[1].substring(0, t[1].length()-2);
            int aAge = Integer.parseInt(age);
            if (aAge > 60) 
                count++;
        }

        return count;
    }
}