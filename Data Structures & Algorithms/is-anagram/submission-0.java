class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        // Build the token pile for s
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // Spend tokens using t's characters
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            // Character not in pile at all → fail
            if (!count.containsKey(c)) return false;

            // Spend one token
            count.put(c, count.get(c) - 1);

            // Ran out of tokens → t has too many of this char
            if (count.get(c) < 0) return false;
        }

        // Same length + every token spent exactly → anagram
        return true;
    }
}
