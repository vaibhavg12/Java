A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.

Assume that:

N is an integer within the range [1..2,147,483,647].
Complexity:

expected worst-case time complexity is O(log(N));
expected worst-case space complexity is O(1).



// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        if(N < 1)
            return -1;    
        int res = 0;
        int gapLen = 0;
        boolean binGapStart = false;
        boolean gapZeroes = false;           
        while(N >= 1) {
            if(N%2 == 1) {
                binGapStart = binGapStart && gapZeroes;              
                if(binGapStart) {
                    res = (res > gapLen)? res:gapLen;
                    gapZeroes = false;
                    gapLen = 0;
                }
                else
                    binGapStart = true;
            }
            else{
                gapZeroes = binGapStart;
                if(gapZeroes)
                    gapLen++;
            }           
            N = N/2;
        }       
        return res;       
    }
}