/*
 * Remove all val and return the number which are not val
 * Two pointers
 */
class Solution{
    public int removeElement(int[] nums, int val){
        //fast, slow pointers
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++){
            if (nums[fastIndex] != val){
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}