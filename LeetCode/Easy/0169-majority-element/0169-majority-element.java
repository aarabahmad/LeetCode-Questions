class Solution {
    public int majorityElement(int[] nums) {
        int count=0, majority=0;
        for(int i : nums) {
            if(count==0) {
                majority=i;
                count++;
                continue;
            }
            if(majority==i) {
                count++;
            }
            else if(majority!=i) {
                count--;
            }
        }
        return majority;
    }
}