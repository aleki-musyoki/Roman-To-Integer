package com.projects.roman;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(romanToInteger("ZP"));
        System.out.println(romanToInteger("XXVII"));
        System.out.println(romanToInteger("IX"));
        System.out.println(romanToInteger("LL"));
        System.out.println(romanToInteger(""));
    }

    public static int romanToInteger(String s) {//XXVI
        String roman = s.toUpperCase();//XXVI

        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int total = 0;
        int previous = 0;
        char previousCharacter = ' ';

        for (int i = 0; i < roman.length(); i++) {//XXVI
            char currentCharacter = roman.charAt(i);//XXVI

            if (!hashMap.containsKey(currentCharacter)){//XX
                return -1;//If it is an invalid character such as PZI ...etc
            }

            if(currentCharacter == previousCharacter && (currentCharacter == 'L' || currentCharacter == 'V' || currentCharacter == 'D'))//X
                return -1;//If it is an invalid combination --> VV, LL, etc

            int currentVal = hashMap.get(currentCharacter);//X--> 10 X - 10 v - 5 i - 1

            if(previous < currentVal){//prev -0 current - 10 previous - 10 current - 5, previous - 5 current - 1
                total = total  - previous;//
            }else{
                total = total + previous;//total - 10+10+5 25
            }
            previous = currentVal;//previos - 10 previous --> 1
            previousCharacter = currentCharacter;//X
        }
        total = total + previous; //total 25 -> previous - 1 = 26

        return total;//26
    }
}
/*
 * Pseudocode:
 * Get the string from method and convert it all to uppercase --> Reduce errors
 * Initialize hashmap with key value pairs for all possible letters in roman numerals (L, X, I, V)
 * Initialize variable total to 0 --> Where to tabulate the result for the entire roman string
 * Initialize a variable previous to  0 --> Where to store our previous value
 * Initialize a variable previous Character to an empty character --> Where to store previous character in the string
 * Start a for loop -> from 0 to array length to check each character in the string (left to right)
 * Check to see if the character is in the hashmap and therefore if it is valid --> If not valid return -1
 * Check for invalid repetitions as well --> VV LL etc.
 *      Check if the current character is same as previous character and if it either L, V or D which should not be repeated --> return -1 if invalid
 * Get the integer value for the current character from the hashmap --> store it in variable current
 * --> Subtractive rule -> if the next value is greater than the current one then minus next value from the current one to get result
 *      E.g IX -> 1 is less than 10 so take 10 - 1 to get 9 as result
 * Compare previous and current (To allow us to do the subtractive method to get the result)
 * if the previousVal is less than the currentVal --> A case like IX
 *   then minus previousVal from total to get the result
 * else --> A case like XI
 *  add the previous value to the result and continue the loop
 * Set the previous value to the current value --> because we don't have any other way to loop through without getting outofbounds exception
 * Repeat the loop till the currentVal is at the last digit.
 * outside the loop add the previous value to the total --> the last iteration will not add the previous value because array is at max
 * return 0 if it is not getting anything
 * */