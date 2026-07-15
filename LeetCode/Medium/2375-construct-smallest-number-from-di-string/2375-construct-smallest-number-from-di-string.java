class Solution {
    public String smallestNumber(String pattern) {
        int length = pattern.length();
        StringBuilder ans = new StringBuilder("123456789");
        Stack<Integer> stack = new Stack<>();
        int iORd = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (pattern.charAt(i) == 'D') {
                iORd++;
            } else {
                if (iORd!=0) {
                    stack.push(iORd);
                }
                iORd = 0;
                stack.push(iORd);
            }
        }
        if (iORd!=0) {
            stack.push(iORd);
        }
        int i = 1;
        while (!stack.isEmpty()) {
            if (stack.peek()==0) {
                i++;
            } else {
                int count=stack.peek();
                int start = i - 1;
                int end = i + count;
                String reversed = new StringBuilder(ans.substring(start, end)).reverse().toString();
                ans.replace(start, end, reversed);
                i += count;
            }
            stack.pop();
        }
        return ans.substring(0, length + 1);
    }
}