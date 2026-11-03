class Solution {
    private long spf(long a) {
        if (a%2 == 0)
            return 2;
        int i = 3;
        while (i*i <= a) {
            if (a % i == 0)
                return i;
            i += 2;
        }
        return a;
    }
    public long minimumMaxValue(int n, int index, int value) {
        if (value == 1)
            return -1;
        var spf = spf(value);

        int onRight = n-index-1;
        long gap = 0;
        if (onRight == 0) {
            gap = 0;
        }
        else {
            gap += spf;
            gap += 2*(onRight-1);
        }

        if (index == 0)
            return value+gap;

        int temp = value;
        temp -= spf;
        temp -= 2*(index-1);
        if (temp <= 1)
            return -1;

        return value+gap;
    }
}