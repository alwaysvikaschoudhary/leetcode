class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0; // Minimum possible open '('
        int maxOpen = 0; // Maximum possible open '('

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else if (c == '*') {
                // * can be '(', ')' or ''
                minOpen--;   // Treat as ')'
                maxOpen++;   // Treat as '('
            }

            // If maxOpen goes below 0, too many ')'s
            if (maxOpen < 0) return false;

            // minOpen should not be negative (we can't have less than 0 open)
            minOpen = Math.max(minOpen, 0);
        }

        // If minOpen == 0, all open parentheses matched
        return minOpen == 0;
    }
}
