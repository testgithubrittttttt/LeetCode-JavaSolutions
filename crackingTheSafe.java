class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder result = new StringBuilder();
        Set<String> seen = new HashSet<>();
        String startNode = String.join("", Collections.nCopies(n - 1, "0"));

        dfs(startNode, k, seen, result);

        result.append(startNode); // Append the start node at the end
        return result.toString();
    }

    private void dfs(String node, int k, Set<String> seen, StringBuilder result) {
        for (int i = 0; i < k; i++) {
            String next = node + i;
            if (!seen.contains(next)) {
                seen.add(next);
                dfs(next.substring(1), k, seen, result);
                result.append(i);
            }
        }
    }
}