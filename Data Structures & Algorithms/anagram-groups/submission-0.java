class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        /*
        Construct the key by sorting the string and using that for comparisons, similar to a hash

        */
        HashMap<String, List<String>> anagrams = new HashMap<>();
        for (int i = 0 ; i < strs.length; i ++ )
        {
            String hashed = hash(strs[i]);
            List<String> grams = anagrams.getOrDefault(hashed, new ArrayList<>());
            grams.add(strs[i]);
            anagrams.put(hashed, grams);

        }

        return new ArrayList<>(anagrams.values());
    }


    public String hash(String str)
    {
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars)
        {
            int count = map.getOrDefault(c, 0);
            map.put(c, count+1);
        }

        StringBuilder sb = new StringBuilder("");
        List<Character> sorted_chars = new ArrayList<>(map.keySet());
        for (int i = 0; i < sorted_chars.size(); i++ )
        {
            char c = sorted_chars.get(i);
            int c_count = map.get(c);
            sb.append(c).append(c_count);
        }

        return sb.toString();
        
    }


}
