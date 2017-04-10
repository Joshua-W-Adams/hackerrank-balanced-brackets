import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n = 0;
        String[] response = new String[t];
        
        // Loop through each passed String
        for(int a0 = 0; a0 < t; a0++){
            
            // Handle any errors produced
            try {
                
                String s = in.next();
                Character[] matchingBracket = new Character[s.length()];
                n = 0;
                
                // Loop through each character in passed string
                for (int i=0; i < s.length(); i++) {

                    Character c = s.charAt(i);

                    // Check for pass/fail status
                    if (s.length() == 1) {
                        response[a0] = "NO";
                    } else if (i == (s.length() - 1) && (c == '(' || c == '[' || c == '{')) {
                        response[a0] = "NO";
                    } else if (c == matchingBracket[n]) {
                        response[a0] = "YES";
                        n--;
                    } else if (c == '(') {
                        response[a0] = "YES";
                    } else if (c == '[') {
                        response[a0] = "YES";
                    } else if (c == '{') {
                        response[a0] = "YES";
                    } else {
                        response[a0] = "NO";
                    }

                    // Save array of open brackets for closing
                    switch (c) {
                        case '(': n++;
                                  matchingBracket[n] = ')';
                        break;
                        case '[': n++;
                                  matchingBracket[n] = ']';
                        break;
                        case '{': n++;
                                  matchingBracket[n] = '}';
                        break;
                    }

                    // Confirm all open brackets have been closed out
                    if (i == (s.length() - 1) && n != 0) {
                        response[a0] = "NO";
                    }

                    // Exit loop if any bracket failed
                    if (response[a0] == "NO") {
                        i = s.length();
                    }

                }

                System.out.println(response[a0]);
                
            } catch (Exception e) {
                
                System.out.println("NO");
                
            }
        }
    }
}
