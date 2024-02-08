//Two-pointers
class Solution{
    public int[] sortedSquares(int[] nums){

        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int index = nums.length - 1;

        while(left <= right){
            if(nums[left] * nums[left] > nums[right] * nums[right]){
                result[index--] = nums[left] * nums[left++];
            }else{
                result[index--] = nums[right] * nums[right--];
            }
        }
        return result;
    }
}