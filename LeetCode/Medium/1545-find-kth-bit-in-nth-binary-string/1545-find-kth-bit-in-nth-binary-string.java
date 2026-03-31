class Solution {

    public char findKthBit(int n, int k) {
        StringBuilder result=find(n, k, new StringBuilder(), 0);
        return result.toString().charAt(k-1);
    }

    public StringBuilder inversion(StringBuilder res) {
        String invert=res.toString();
        invert=invert.replace('0', '-');
        invert=invert.replace('1', '0');
        invert=invert.replace('-', '1');
        return new StringBuilder(invert);
    }

    public StringBuilder find(int n, int k, StringBuilder res, int index) {
        if(index>n) {
            return res;
        }
        if(index==0) {
            res.append(0);
        }
        else {
            StringBuilder invert=inversion(res);
            res.append(1);
            res.append(invert.reverse());
        }
        return find(n, k, res, index+1);
    }
    
}