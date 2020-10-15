class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        
		for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
		
        return new ArrayList(ans.values());
    }
}

/*Maintain a map ans : {String -> List} where each key K is a sorted string, 
and each value is the list of strings from the initial input that when sorted, are equal to K.
Time Complexity: O(NKlog K), where N is the length of strs, 
and K is the maximum length of a string in strs.
 The outer loop has complexity O(N) as we iterate through each string. 
 Then, we sort each string in O(KlogK) time.
Space Complexity: O(NK)O(NK), the total information content stored in ans.
*/