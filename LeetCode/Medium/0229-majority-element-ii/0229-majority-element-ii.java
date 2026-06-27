class Solution {
    static int mini=Integer.MIN_VALUE;
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int majorityOne=mini, countOne=0;
        int majorityTwo=mini, countTwo=0;
        for(int num : nums) {
            if(majorityOne!=mini && num==majorityOne) {
                countOne++;
            }
            else if(majorityTwo!=mini && num==majorityTwo) {
                countTwo++;
            }
            else if(countOne==0) {
                majorityOne=num;
                countOne=1;
            }
            else if(countTwo==0) {
                majorityTwo=num;
                countTwo=1;
            }
            else {
                countOne--;
                countTwo--;
            }
        }
        countOne=0;
        countTwo=0;
        for(int num : nums) {
            if(num==majorityOne) {
                countOne++;
            }
            else if(num==majorityTwo) {
                countTwo++;
            }
        }
        List<Integer> majority=new ArrayList<>();
        if(countOne>n/3) {
            majority.add(majorityOne);
        }
        if(countTwo>n/3) {
            majority.add(majorityTwo);
        }
        return majority;
    }
}