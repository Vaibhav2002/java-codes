package leetcode;

import java.util.Arrays;

public class SearchInRotatedSorted {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int ans;
        if(pivot==-1)
            ans= Arrays.binarySearch(nums,0,nums.length,target);
        else if (target >= nums[0])
            ans = Arrays.binarySearch(nums, 0, pivot, target);
        else
            ans = Arrays.binarySearch(nums, pivot, nums.length, target);
        return ans < 0 ? -1 : ans;


    }

    int findPivot(int[] a) {
        int l = 0, u = a.length;
        while (l < u) {
            int mid = l + (u - l) / 2;
            if (mid < a.length - 1 && a[mid] > a[mid + 1])
                return mid + 1;
            if (mid > 0 && a[mid] < a[mid - 1])
                return mid;
            if (a[mid] > a[l])
                l = mid + 1;
            else
                u = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSorted ob = new SearchInRotatedSorted();
        System.out.println(ob.search(new int[]{-2}, -2));
    }
}
