package dailyCode.arrays.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubStringWithoutDuplicates {

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(solve(str));
    }

    private static int solve(String str) {
        // Map to store the last index at which each character was seen
        Map<Character, Integer> hmap = new HashMap<>();
        int slow = 0;
        int max = 0;
        int fast = 0;
        // Expand the window by moving the fast pointer
        while (fast < str.length()) {
            // Current character at fast pointer
            char c = str.charAt(fast);

            // If character already seen and is inside the current window
            if (hmap.containsKey(c)) {
                // Move slow pointer just after the last occurrence of c
                // Math.max ensures slow never moves backward
                slow = Math.max(slow, hmap.get(c) + 1);
            }

            // Update the last seen index of the current character
            hmap.put(c, fast);

            // Move fast pointer to expand the window
            fast++;
            // Update maximum length of substring without repeating characters
            max = Math.max(max, fast - slow);
        }
        return max;
    }
}
