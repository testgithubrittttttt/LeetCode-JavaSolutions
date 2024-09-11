// # Given an array of characters chars, compress it using the following algorithm:

// # Begin with an empty string s. For each group of consecutive repeating characters in chars:

// # If the group's length is 1, append the character to s.
// # Otherwise, append the character followed by the group's length.
// # The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

// # After you are done modifying the input array, return the new length of the array.

// # You must write an algorithm that uses only constant extra space.

// # Example 1:

// # Input: chars = ["a","a","b","b","c","c","c"]
// # Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
// # Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
// # Example 2:

// # Input: chars = ["a"]
// # Output: Return 1, and the first character of the input array should be: ["a"]
// # Explanation: The only group is "a", which remains uncompressed since it's a single character.
// # Example 3:

// # Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
// # Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
// # Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 
class Solution {
    public int compress(char[] chars) {
        char previousChar = chars[0];
        int count=1;//it takes the count of the previousChar.
        StringBuilder sb = new StringBuilder();//this is for building compressed string

        //basically if we see carefully we are using two pointer approach.

        for(int i=1; i<chars.length; i++){//iteration
            char currentChar = chars[i];

            if(previousChar == currentChar){//character matching
                count++;//if yes then increase it's count
            } 

            else {//if previous is not equal to current.
                sb.append(previousChar);//from this we start putting the characters in the array
                if(count > 1) sb.append(count);// if their count is more than one than we also append there count with them also.
                previousChar = currentChar;//updation of previous one takii hum agle character pe ja ske.
                count=1;// resetting thre count again to 1 for other character.
            }
        }        
        sb.append(previousChar);//loop ends and we get our last charcter
        if(count > 1) sb.append(count);//if last character count is bigger than 1 than append it.

        for(int i=0; i<sb.length(); i++){
            chars[i] = sb.charAt(i);//putting answer of ab back to chars.
        }
        return sb.length();//at the end we get the required string length.
    }
}

// You are given a string s, which contains stars *.

// In one operation, you can:

// Choose a star in s.
// Remove the closest non-star character to its left, as well as remove the star itself.
// Return the string after all stars have been removed.

// Note:

// The input will be generated such that the operation is always possible.
// It can be shown that the resulting string will always be unique.

class Solution {
    public String removeStars(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        int j = 0;

        while(j < s.length()){
            if(c[j] == '*') i--;
            else c[i++] = c[j];
            j++;
        }
        return new String(c, 0 , i);
    }
}