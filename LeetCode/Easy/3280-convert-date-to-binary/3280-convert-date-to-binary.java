class Solution {
    public String decTobin(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n & 1);
            n >>= 1;
        }
        String binary = sb.reverse().toString();
        return binary;
    }
    public String convertDateToBinary(String date) {
        String[] str=date.split("-");
        List<Integer> list=new ArrayList<>();
        for(String s : str) {
            list.add(Integer.parseInt(s));
        }
        String binary[]=new String[list.size()];
        for(int i=0;i<list.size();i++) {
            binary[i]=(decTobin(list.get(i)));
        }
        String res=String.join("-", binary);
        return res;
    }
}