import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) 
    {
        
long iPalCount = n;
    long iSpecialCnt = 0, iCurrCount = 0, iPrevCount = 0, iPrevPrevCount = 0;
    
    for(int i = 1; i < n; i++) {
        char cPrev = s.charAt(i-1);
        char cCurr = s.charAt(i);
        
        if ( cPrev == cCurr ) {
            iCurrCount++;
            iPalCount += iCurrCount;
            
            if ( iSpecialCnt > 0 ) {
                iSpecialCnt--;
                iPalCount++;
            }
        }
        else {
            iCurrCount = 0;
            if ( i > 1 && (s.charAt(i-2) == cCurr) ) {
                iSpecialCnt = iPrevPrevCount;
                iPalCount++;
            }
            else {
                iSpecialCnt = 0;
            }
        }
        
        if ( i > 1 ) {
            iPrevPrevCount = iPrevCount;
        }
        
        iPrevCount = iCurrCount;
    }
    
    return iPalCount;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
