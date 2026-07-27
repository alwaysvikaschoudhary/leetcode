class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int s = nums[0];
        int l = nums[1];

        for(int i=2; i<n; i++) {
            if(nums[i] > s && s < l) s=nums[i];
            else if(nums[i] > l) l=nums[i];
        }

        return (s-1)*(l-1);
    }
}