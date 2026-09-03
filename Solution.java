class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int m = people.length;
        Arrays.sort(people, Comparator.comparingInt((int[] x) -> x[0]).thenComparingInt(x -> x[1]));

        int[][] result = new int[m][2];

        for (int i = 0; i<m; i++) {
            result[i][0] = -1;
        }

        for (int i = 0; i<m; i++) {
            int count = people[i][1];
            int j = 0;
            while (j < m) {
                if (result[j][0] > -1) {
                    if (result[j][0] == people[i][0])
                        count--;
                    j++;
                    continue;
                }

                if (count == 0) {
                    result[j] = people[i];
                    System.out.println(j+" , "+Arrays.toString(result[j]));
                    break;
                }
                else {
                    count--;
                    j++;
                }
            }
        }

        return result;
    }
}