class Solution {
    public String[] divideString(String s, int k, char fill) {
        String[] res=new String[s.length()%k==0?s.length()/k:s.length()/k+1];
        int index=0;
        for(int i=0;i<s.length();) {
            int ind=0;
            String val="";
            while(i<s.length() && ind<k) {
                val+=s.charAt(i);
                i++;
                ind++;
            }
            res[index]=val;
            index++;
        }
        while(res[res.length-1].length()!=k){
            res[res.length-1]+=fill;
        }
        return res;
    }
}