class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
        	int mid = left + ((right-left)/2);
        	int a = nums[left], b = nums[mid] , c = nums[right-1];
        	if (b == target)
        		return mid;
        	
        	if (a < b) {
        		if (target < b && target >= a) {
        			right = mid;
        			continue;
        		}
        		else {
        			left = mid+1;
        			continue;
        		}
        	}
        	else {
        		if (target < b || target >= a) {
        			right = mid;
        			continue;
        		}
        		else {
        			left = mid+1;
        			continue;
        		}
        	}
        }
        return -1;
    }
}