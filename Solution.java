class Solution {
    public int[] closestPrimes(int left, int right) {
        int n = right+1;
        boolean[] isPrime = new boolean[n+1];
        for (int i = 0; i<n; i++)
        	isPrime[i] = true;
        isPrime[0] = isPrime[1] = false;

        List<Integer> list = new ArrayList<>();

        for (int i = 2; i<n; i++) {
        	if (isPrime[i]) {
        		if (i >= left) {
        			list.add(i);
        		}
        	}
        	if ((long) i*i < n) {
        		for (int j = i*i; j<n; j+=i) {
        			isPrime[j] = false;
        		}
        	}
        }
        
        int[] result = new int[2];
        result[0] = result[1] = -1;
        if (list.size() <= 1) {
            return result;
        }

        int min = Integer.MAX_VALUE;
        int i = 1;
        while (i < list.size()) {
            int leftNum = list.get(i-1), rightNum = list.get(i);
            if (rightNum-leftNum < min) {
                min = rightNum-leftNum;
                result[0] = leftNum;
                result[1] = rightNum;
            }
            i++;
        }

        return result;
    }
}