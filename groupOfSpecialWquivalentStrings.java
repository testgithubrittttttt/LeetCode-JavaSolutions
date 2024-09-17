class Solution {
    public int numSpecialEquivGroups(String[] words) {
        Set<String> uniqueGroups = new HashSet<>();
        
        for (String word : words) {
            char[] evenChars = new char[(word.length() + 1) / 2];
            char[] oddChars = new char[word.length() / 2];
            
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    evenChars[i / 2] = word.charAt(i);
                } else {
                    oddChars[i / 2] = word.charAt(i);
                }
            }
            
            Arrays.sort(evenChars);
            Arrays.sort(oddChars);
            
            String identifier = new String(evenChars) + new String(oddChars);
            uniqueGroups.add(identifier);
        }
        
        return uniqueGroups.size();
    }
}