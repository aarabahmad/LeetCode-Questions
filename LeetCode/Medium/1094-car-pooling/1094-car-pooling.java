class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diffArray=new int[1001];
        for(int[] trip : trips) {
            int numPassengers=trip[0];
            int source=trip[1];
            int destination=trip[2];
            diffArray[source]+=numPassengers;
            diffArray[destination]-=numPassengers;
        }
        int passengers=0;
        for(int value : diffArray) {
            passengers+=value;
            if(passengers>capacity) {
                return false;
            }
        }
        return true;
    }
}