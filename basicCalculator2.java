// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.trim();
        int curr = 0; char lastSign = '+';
        int calc = 0; int tail = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr*10 + c - '0';
            } 
            
            if( (!Character.isDigit(c) && c!=' ') || i == s.length()-1 ){
                if(lastSign == '+'){
                    calc = calc + curr;
                    tail = +curr;
                } else if(lastSign == '-'){
                    calc = calc - curr;
                    tail = -curr;
                } else if(lastSign == '*'){
                    calc = calc - tail + (tail*curr);
                    tail = tail * curr;
                } else if(lastSign == '/'){
                    calc = calc - tail + (tail/curr);
                    tail = tail / curr;
                }
                lastSign = c;
                curr = 0;
            }
        }
        return calc;
    }
}