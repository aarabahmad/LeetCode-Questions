class Solution {
    public int maxProduct(int[] nums) {
        int i=0;
        int result=Integer.MIN_VALUE;
        int leftProd=1, rightProd=1;
        while(i>=0 && i<nums.length) {
            leftProd*=nums[i];
            rightProd*=nums[nums.length-i-1];
            result=Math.max(result, Math.max(leftProd, rightProd));
            leftProd=(leftProd==0)?1:leftProd;
            rightProd=(rightProd==0)?1:rightProd;
            i++;
        }
        return result;
    }
}